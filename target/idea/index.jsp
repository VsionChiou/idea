<%--
  Created by IntelliJ IDEA.
  User: Vsion
  Date: 2023/8/28
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作简历</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="./css/style.css">

    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
</head>
<body style="height:auto;background:#f8f8f8;">
<div class="n_dispage_jm">
    <div class="n_dispage_jm_in">
        <div class="head">
            <div class="head_left">
                <div class="name">邱茂顺</div>
                <div class="sex">性别：男</div>
            </div>
            <div class="head_middle">
                <div class="birth">
                    <p class="fa fa-calendar"> </p><span> 1997.07.19</span>
                </div>
                <div class="location">
                    <p class="fa fa-map-marker"></p><span> 山东省济宁市</span>
                </div>
                <div class="phone">
                    <p class="fa fa-phone"></p><span> 158-6377-7160</span>
                </div>
                <div class="mail">
                    <p class="fa  fa-envelope"></p><span> qmsucc97@163.com</span>
                </div>
            </div>
            <div class="head_right">
                <img src="./images/Myself.JPEG" alt="">
            </div>
        </div>
        <div>
            <div class="edu">
                <div class="title">
                    <div class="label-part">教育背景</div>
                    <div class="triangle"></div>
                    <div class="line"></div>
                </div>
                <div class="container">
                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp2021.09 - 2024.06</div>
                            <div>曲阜师范大学</div>
                            <div>软件工程</div>
                            <div>硕士</div>
                        </div>
                        <div class="course">
                            <div class="fa  fa-circle"></div>
                            <p>&nbsp&nbsp&nbsp研究方向：目标检测</p>
                        </div>
                    </div>

                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp2016.09 - 2020.06</div>
                            <div>齐鲁工业大学</div>
                            <div>物联网工程</div>
                            <div>学士</div>
                        </div>
                        <div class="course">
                            <div class="fa  fa-circle"></div>
                            <p>&nbsp&nbsp&nbsp主修课程：数据结构、操作系统、计算机组成原理、计算机网络、电路、嵌入式系统、物联网控制技术</p>
                        </div>
                    </div>
                </div>


            </div>
            <div class="school">
                <div class="title">
                    <div class="label-part">校园经历</div>
                    <div class="triangle"></div>
                    <div class="line"></div>
                </div>
                <div class="container">

                    <ul>
                        <li>
                            <div>
                                <div>✓ &nbsp&nbsp天文社团</div>
                                <div>宣传部长</div>
                                <div>2018.09-2020.06</div>
                            </div>

                        </li>
                        <li>
                            <div>
                                <div>✓ &nbsp&nbsp体育（乒乓球）</div>
                                <div>体育委员</div>
                                <div>2018.09-2019.09</div>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div>✓ &nbsp&nbsp乒乓球社团</div>
                                <div>助理</div>
                                <div>2018.09-2019.09</div>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div>✓ &nbsp&nbsp学术科技部</div>
                                <div>部长</div>
                                <div>2017.09-2018.09</div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="project">
                <div class="title">
                    <div class="label-part">项目实践</div>
                    <div class="triangle"></div>
                    <div class="line"></div>
                </div>
                <div class="container">
                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp无人售货柜</div>
                            <div>团队项目</div>
                            <div>2022.11-至今</div>
                        </div>
                        <div class="content">
                            <div class="bref">
                                <p><span>项目介绍：</span>拉取货柜摄像头视频流，转推给检测服务器，检测服务器实时识别商品以及数量生成订单，
                                    转交由购物系统处理扣费。</p>
                            </div>
                            <div class="method">
                                <p>实现方法{相关技术}(难点举例)：</p>
                                <ul>
                                    <li>摄像头SDK取流以及I\O控制{C++}(通过Linux驱动ioctl、gpio、watchdog等控制柜门锁的开关；网络摄像头SDK调试与重写)</li>
                                    <li>视频推拉流和编解码{FFmpeg}(编解码器的实现；推流速率控制)</li>
                                    <li>流媒体服务器{ZLMediaKit}</li>
                                    <li>后端流程控制{Django}(设备端与服务端推拉流同步)</li>
                                    <li>目标检测算法{pytorch}(网络结构调优)</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp无人配送小车</div>
                            <div>个人项目</div>
                            <div>2019.12-2020.03</div>
                        </div>
                        <div class="content">
                            <div class="bref">
                                <p><span>项目介绍：</span>
                                    使用STM32控制电机驱动；结合TOF、超声波传感器和摄像头实现小车的环境感知；设计算法使得小车具备自动路线规划、
                                    自动避障和回溯路线的能力；WiFi模块结合MQTT实现网络通信；客户端实时传输达到软硬件协同的功能。
                                </p>
                            </div>
                            <div class="method">
                                <p>实现方法{相关技术}(难点举例)：</p>
                                <ul>
                                    <li>STM32驱动开发{C++}(HAL库的使用；UART不定长数据的收发；PID调参；多传感器数据融合；MQTT协议实现)</li>
                                    <li>WEB客户端{前端：HTML+CSS+JS；后端：Django}</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp图床</div>
                            <div>团队项目</div>
                            <div>2019.12-2019.12</div>
                        </div>
                        <div class="content">
                            <div class="bref">
                                <p><span>项目介绍：</span>
                                    使用Django框架编写的用于显示用户上传图片的网站，实现功能：用户注册、登录，权限设置。
                                </p>
                            </div>
                            <div class="method">
                                <p>实现方法{相关技术}(难点举例)：</p>
                                <ul>
                                    <li>前端设计编写{HTML+CSS+JS}</li>
                                    <li>后端逻辑实现{Python,Django}</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp温湿度检测报警系统</div>
                            <div>团队项目</div>
                            <div>2019.06-2019.06</div>
                        </div>
                        <div class="content">
                            <div class="bref">
                                <p><span>项目介绍：</span>
                                    STM32做控制器，通过DHT22采集数据通过WiFi上传到服务器，前端或小程序从服务器实时获取数据，一旦达到警戒阈值则报警。
                                </p>
                            </div>
                            <div class="method">
                                <p>实现方法{相关技术}(难点举例)：</p>
                                <ul>
                                    <li>服务器搭建{TCP通信；数据库CRUD}(并发数据处理)</li>
                                    <li>前后端逻辑实现{Java；HTML+CSS+JS}</li>
                                    <li>微信小程序</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="part">
                        <div class="name">
                            <div>✓ &nbsp&nbsp超市收银系统</div>
                            <div>团队项目</div>
                            <div>2018.06-2018.06</div>
                        </div>
                        <div class="content">
                            <div class="bref">
                                <p><span>项目介绍：</span>实现如商品入库管理、收银结算、员工登录、权限设置等功能的可视化收银系统。</p>
                            </div>
                            <div class="method">
                                <p>实现方法{相关技术}(难点举例)：</p>
                                <ul>
                                    <li>数据库关系模型的设计与建立{mysql}</li>
                                    <li>GUI界面{Java Swing}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="skill">
                <div class="title">
                    <div class="label-part">个人技能</div>
                    <div class="triangle"></div>
                    <div class="line"></div>
                </div>
                <div class="container">
                    <p>技能证书：（1）普通话二级乙等；（2）大学英语四级（CET-4）；（3）中级软件设计师（软考）；</p>
                    <p>擅长编程语言：Python、C/C++、Java；</p>
                    <p>熟练Arm平台嵌入式开发，熟悉Linux编程及软件编译，熟悉STL和QT框架。</p>
                    <p>熟练使用Django等框架，熟悉Linux操作系统及Docker使用。</p>
                </div>
            </div>
            <div class="self">
                <div class="title">
                    <div class="label-part">自我评价</div>
                    <div class="triangle"></div>
                    <div class="line"></div>
                </div>
                <div class="container">
                    <p>本人自小对计算机有浓厚的兴趣，小时自学装系统，折腾黑苹果，勇于探索实践，喜欢求根问底，不甘失败。</p>
                    <p>大学四年随性而不堕落，专业排名TOP50%，一直在为提升自身而不懈努力。喜欢探求原理，了解技术的具体实现。自学C++等编程语言。
                        研究生期间主要在嵌入式目标检测方向不端探索，曾经尝试将神经网络模型移植到Arm嵌入式开发板、Android手机。</p>
                    <p>本人性格内敛但喜欢通过交流解决问题。通过大学英语四级，精通软件与嵌入式开发。课余时间读书、思考、折腾计算机。</p>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>
