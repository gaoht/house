#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
Created on 2018/05/23

@author: gaoht
"""
from pymongo import MongoClient
import requests
import time
import smtplib
from email.mime.text import MIMEText
from email.header import Header



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


def jiandemen_spider():
    """
    curl -H 'Accept: application/json;version=6' -H 'Host: phoenix.ziroom.com' -H 'User-Agent: okhttp/3.10.0' --compressed 'https://phoenix.ziroom.com/v7/room/list.json?os=android%3A8.1.0&app_version=5.5.9&ip=192.168.1.107&sign=f8785849d1a7a90dfe01ef8e618f2117&city_code=110000&type=12&network=WIFI&uid=119387a0-974c-1923-5a54-004fb5dc8ee7&sign_open=1&size=10&subway_code=10%E5%8F%B7%E7%BA%BF&price=%2C&imei=864630039151336&model=ONEPLUS+A5000&page=1&subway_station_code=%E5%81%A5%E5%BE%B7%E9%97%A8&timestamp=1529418950'
    """
    page = 1
    size = 10
    headers = {
        "User-Agent": "okhttp/3.10.0",
        "Host": "phoenix.ziroom.com",
        "Accept": "application/json;version=3",
        "Connection": "Keep-Alive",
        "Accept-Encoding": "gzip"
    }
    params = {
        "os": "android:8.1.0",
        "app_version": "5.5.9",
        "ip": "192.168.1.107",
        "sign": "f8785849d1a7a90dfe01ef8e618f2117",
        "city_code": "110000",
        "type": "12",
        "network": "WIFI",
        "uid": "119387a0-974c-1923-5a54-004fb5dc8ee7",
        "sign_open": "1",
        "size": "10",
        "subway_code": "10号线",
        "price": ",",
        "imei": "864630039151336",
        "model": "ONEPLUS+A5000",
        "page": "1",
        "subway_station_code": "健德门"
    }
    total = 0
    room_tips = []
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
                if room['price'] < 7500 and room['status'] != 'ycz' \
                        and room['status'] != 'zxpzz' and room['price_unit'] == '元/月':
                    room_tips.append(room)
            if lenn < size:
                break
            else:
                page += 1
                time.sleep(0.2)
        else:
            print(res['error_message'])
            break
    print('总共爬取%d条数据' % total)
    if len(room_tips) > 0:
        htmls = ["<table border='1'><thead><tr><th>名字</th><th>价格</th><th>面积</th><th>朝向</th><th>楼层</th><th>亮点</th><th>链接</th></tr></thead><tbody>"]
        for tip in room_tips:
            text = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>" % \
                   (tip.get("name", "名字"), tip.get("price", "$0.0"), tip.get("area", "0.0"), tip.get("face", "无"),
                    tip.get("floor", 0) + "/" + tip.get("floor_total", 0), tip.get("subway_station_info", "无") ,
                    "http://m.ziroom.com/BJ/room/" + tip.get("id", "1") + ".html"
                    )
            htmls.append(text)
        htmls.append("</tbody></table>")
        send_email("350200164@qq.com", ['350200164@qq.com', '970408321@qq.com'], "房子信息", "", "".join(htmls))



def send_email(fromAdd, toAdd, subject, attachfile, htmlText):
    msg = MIMEText(htmlText)
    msg['Content-Type'] = 'Text/HTML'
    msg['Subject'] = Header(subject, 'utf-8')
    msg['To'] = fromAdd
    msg['From'] =  ','.join(toAdd)

    smtp = smtplib.SMTP_SSL('smtp.qq.com', 465)
    smtp.login('350200164@qq.com', 'qmquypgdqgskbifh')
    try:
        smtp.sendmail(fromAdd, toAdd, msg.as_string())
    finally:
        smtp.close


def save_db(db, data, collection):
    db[collection].save(data)


if __name__ == '__main__':
    # ziroom_spider()
    # ziroom_detail()
    # print('搞定')/
    while True:
        jiandemen_spider()
        time.sleep(300)
    # send_email('350200164@qq.com', ['350200164@qq.com', '970408321@qq.com'], "hhh", "", "哈哈哈哈")
# dzz 立即签约
# ycz 已预订