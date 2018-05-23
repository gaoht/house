"""
Created on 2018/05/23

@author: gaoht
"""
from pymongo import MongoClient
import requests
import time


def ziroom_spider():
    """
    curl -H 'Accept: application/json;version=6' -H 'Host: phoenix.ziroom.com' -H 'User-Agent: okhttp/3.10.0' --compressed 'https://phoenix.ziroom.com/v7/room/list.json?os=android%3A8.1.0&app_version=5.5.6&ip=30.28.163.35&sign=601095dcfab2b4aca5b6889d9d8fc1bf&city_code=110000&type=10&network=WIFI&uid=119387a0-974c-1923-5a54-004fb5dc8ee7&sign_open=1&size=10&price=%2C&imei=864630039151336&model=ONEPLUS+A5000&page=4&timestamp=1527046231'
    """
    headers = {
        "User-Agent": "okhttp/3.10.0",
        "Host": "phoenix.ziroom.com",
        "Accept": "application/json;version=6",
        "Connection": "Keep-Alive",
        "Accept-Encoding": "gzip"
    }
    page = 1
    size = 10
    client = MongoClient('mongodb://localhost:27017/')
    db = client.house
    total = 0
    params = {
        "os": "android:8.1.0",
        "app_version": "5.5.6",
        "ip": "30.28.163.35",
        "city_code": 110000,
        "network": "WIFI",
        "imei": "864630039151336",
        "model": "ONEPLUS A5000",
        "uid": "119387a0-974c-1923-5a54-004fb5dc8ee7",
        # 最大20
        "size": size,
        "price": ",",
        # 1为友家 10为整租 29为精选
        "type": 10,
        # tag: 3 表示只查转租
        # "tag": 3
    }

    while True:
        params['page'] = page
        params["timestamp"] = int(time.time())
        r = requests.get("http://phoenix.ziroom.com/v7/room/list.json", headers=headers, params=params)
        res = r.json()
        if res['error_code'] == 0:
            rooms = res['data']['rooms']
            lenn = len(rooms)
            total += lenn
            for room in rooms:
                room['_id'] = room['id']
                room['loc'] = {
                    "type": "Point",
                    "coordinates": [room['lng'], room['lat']]
                }
                room['timestamp'] = params["timestamp"]
                save_db(db, room, "ziroom")
            if lenn < size:
                break
            else:
                page += 1
                time.sleep(0.2)
            print('总共爬取%d条数据' % total)
        else:
            print(res['error_message'])
            break
    print('总共爬取%d条数据' % total)


def ziroom_detail():
    """
    curl -H 'Accept: application/json;version=3' -H 'Host: phoenix.ziroom.com' -H 'User-Agent: okhttp/3.10.0' --compressed 'https://phoenix.ziroom.com/v7/room/detail.json?house_id=60193590&os=android%3A8.1.0&app_version=5.5.6&ip=30.28.160.251&sign=0475c086a0235421193c69a16a5f7043&city_code=110000&network=WIFI&uid=119387a0-974c-1923-5a54-004fb5dc8ee7&sign_open=1&imei=864630039151336&model=ONEPLUS+A5000&id=61203350&timestamp=1527079136'
    :return:
    """
    headers = {
        "User-Agent": "okhttp/3.10.0",
        "Host": "phoenix.ziroom.com",
        "Accept": "application/json;version=3",
        "Connection": "Keep-Alive",
        "Accept-Encoding": "gzip"
    }
    client = MongoClient('mongodb://localhost:27017/')
    db = client.house
    total = 0
    params = {
        "os": "android:8.1.0",
        "app_version": "5.5.6",
        "ip": "30.28.163.35",
        "city_code": 110000,
        "network": "WIFI",
        "imei": "864630039151336",
        "model": "ONEPLUS A5000",
        "uid": "119387a0-974c-1923-5a54-004fb5dc8ee7",
    }
    zirooms = db.ziroom.find({})
    for room in zirooms:
        params['house_id'] = room['house_id']
        params['id'] = room['id']
        params["timestamp"] = int(time.time())
        r = requests.get("http://phoenix.ziroom.com/v7/room/detail.json", headers=headers, params=params)
        res = r.json()
        if res['error_code'] == 0:
            res = res['data']
            res['_id'] = room['id']
            res['loc'] = {
                "type": "Point",
                "coordinates": [res['resblock']['lng'], res['resblock']['lat']]
            }
            res['timestamp'] = params["timestamp"]
            db.room_detail.save(res)
        total += 1
        time.sleep(0.1)
        if total > 0 and total % 50 == 0:
            print('总共爬取详情%d条数据', total)
    print('总共爬取详情%d条数据', total)


def save_db(db, data, collection):
    db[collection].save(data)


if __name__ == '__main__':
    ziroom_spider()
    ziroom_detail()
    print('搞定')


# dzz 立即签约
# ycz 已预订