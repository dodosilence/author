<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>oauth2.0登录</title>
    <link href="/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resource/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resource/css/lightbox.css" rel="stylesheet">
    <link href="/resource/css/animate.min.css" rel="stylesheet">
    <link href="/resource/css/main.css" rel="stylesheet">
    <link href="/resource/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/resource/js/html5shiv.js"></script>
    <script src="/resource/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="/resource/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="/resource/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="/resource/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="/resource/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resource/images/ico/apple-touch-icon-57-precomposed.png">
    <script type="text/javascript">var switchTo5x = true;</script>
    <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
    <script type="text/javascript">stLight.options({
        publisher: "7e8eb33b-fbe0-4915-9b93-09490e3d10df",
        doNotHash: false,
        doNotCopy: false,
        hashAddressBar: false
    });</script>
</head><!--/head-->

<body>
<jsp:include page="../com/head.jsp"/>
<!--/#header-->


<section id="page-breadcrumb">
    <div class="vertical-center sun">
        <div class="container">
            <div class="row">
                <div class="action">
                    <div class="col-sm-12">
                        <h1 class="title">Oauth2.0登录</h1>
                        <p>授权机制</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--/#page-breadcrumb-->

<section id="blog-details" class="padding-top">
    <div class="container">
        <div class="row">
            <div class="col-md-9 col-sm-7">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="single-blog blog-details two-column">

                            <div class="post-content overflow">
                                <h2 class="post-title bold"><a href="#">Oauth2.0概述</a></h2>
                                <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    OAuth2.0较1.0相比，整个授权验证流程更简单更安全，也是未来最主要的用户身份验证和授权方式。
                                    关于OAuth2.0协议的授权流程可以参考下面的流程图，其中Client指第三方应用，Resource Owner指用户，Authorization
                                    Server是我们的授权服务器，Resource Server是API服务器。
                                    <br> <br>

                                    开发者可以先浏览OAuth2.0的接口文档，熟悉OAuth2.0的接口及参数的含义，然后我们根据应用场景各自说明如何使用OAuth2.0。
                                </p>
                                <br> <br>
                                <%---------------------------------------------------------%>

                                <h2 class="post-title bold"><a href="#">授权流程</a></h2>
                                <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                <div class="post-thumb">
                                    <a href="#"><img src="/resource/images/apis/oauth2.0/oAuth2_01.gif"
                                                     class="img-responsive" style="width: 100%;padding: 30px"
                                                     alt=""></a>
                                    <div class="post-overlay">
                                        <span class="uppercase"><a
                                                href="http://baike.baidu.com/link?url=bQR3w_ocg6BoQRr3JXqUdPpKTl1z6idJq4dcWC9-sNvRXNz0bOUV3op900_jcpGOovpTyjjU4tKCHdgsvO3ri_">
                                            <small>百度</small><br><small>百科</small></a></span>
                                    </div>
                                </div>
                                <br> <br>
                                <%---------------------------------------------------------%>


                                <h2 class="post-title bold"><a href="#">授权步骤</a></h2>
                                <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                <br>
                                <h4>1、获取登录页(GET)</h4>
                                <h5>
                                    地址:http://www.moondust.cc/auth_login?client_id={clientId}&scope={scope}&auth_type={authType}&redirect_url={redirectUrl}&state={state}</h5>
                                <br>
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <td>参数名</td>
                                        <td>类型</td>
                                        <td>例如</td>
                                        <td>可为空</td>
                                        <td>详细</td>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>client_id</td>
                                            <td>String</td>
                                            <td>4028e450565451e20156545321c90000</td>
                                            <td>否</td>
                                            <td>您的客户端的id</td>
                                        </tr>
                                        <tr>
                                            <td>scope</td>
                                            <td>string</td>
                                            <td>read</td>
                                            <td>否</td>
                                            <td>您的客户端可以使用的授权等级</td>
                                        </tr>
                                        <tr>
                                            <td>auth_type</td>
                                            <td>string</td>
                                            <td>auth_code</td>
                                            <td>否</td>
                                            <td>您的客户端可以使用的授权方式</td>
                                        </tr>
                                        <tr>
                                            <td>redirect_url</td>
                                            <td>string</td>
                                            <td>http://www.example.com/auth_code</td>
                                            <td>否</td>
                                            <td>授权成功回调的URL地址，会携带<br>授权码code和下面传入的state状态码</td>
                                        </tr>
                                        <tr>
                                            <td>state</td>
                                            <td>string</td>
                                            <td>1314</td>
                                            <td>是</td>
                                            <td>客户端传给授权服务器的状态码，会<br>随着code返回，用于验证是返回的可信度</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <h4>2、接受授权code</h4>
                                <h5>
                                    回调:您上一步传入的redirect_url?code=democode1234567890&state=1314</h5>
                                <br>
                                <p>这一步您的应用可以接收到换取对应用户的code，code的有效期限为一分钟，一分钟没有兑换则会失效。同时也得到上一步请求时发送的state状态码，您可以验证是不是您发送的请求，若上一步没有传入，则无该参数。</p>

                                <h4>3、换取用户令牌</h4>
                                <h5>
                                    地址:http://www.moondust.cc/</h5>
                                <br>
                                <p>
                                    这一步您的应用可以接收到换取对应用户的code，code的有效期限为一分钟，一分钟没有兑换则会失效。同时也得到上一步请求时发送的state状态码，您可以验证是不是您发送的请求，若上一步没有传入，则无该参数。</p>
                                <br> <br>
                                <br> <br>
                                <%---------------------------------------------------------%>
                                <div class="post-bottom overflow">
                                    <ul class="nav navbar-nav post-nav">
                                        <li><a href="#"><i class="fa fa-tag"></i>Creative</a></li>
                                        <li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
                                        <li><a href="#"><i class="fa fa-comments"></i>3 Comments</a></li>
                                    </ul>
                                </div>
                                <div class="blog-share">
                                    <span class='st_facebook_hcount'></span>
                                    <span class='st_twitter_hcount'></span>
                                    <span class='st_linkedin_hcount'></span>
                                    <span class='st_pinterest_hcount'></span>
                                    <span class='st_email_hcount'></span>
                                </div>
                                <div class="author-profile padding">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <img src="/resource/images/blogdetails/1.png" alt="">
                                        </div>
                                        <div class="col-sm-10">
                                            <h3>Rodrix Hasel</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                                tempor incididunt ut labore et dolore magna aliq Ut enim ad minim
                                                veniam, quis nostrud exercitation ullamco laboris nisi</p>
                                            <span>Website:<a href="www.jooomshaper.com"> www.jooomshaper.com</a></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="response-area">
                                    <h2 class="bold">Comments</h2>
                                    <ul class="media-list">
                                        <li class="media">
                                            <div class="post-comment">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object" src="/resource/images/blogdetails/2.png"
                                                         alt="">
                                                </a>
                                                <div class="media-body">
                                                    <span><i class="fa fa-user"></i>Posted by <a
                                                            href="#">Endure</a></span>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                                        eiusmod tempor incididunt ut labore et dolore magna aliq Ut enim
                                                        ad minim veniam, quis nostrud exercitation ullamco laboris
                                                        nisi.</p>
                                                    <ul class="nav navbar-nav post-nav">
                                                        <li><a href="#"><i class="fa fa-clock-o"></i>February
                                                            11,2014</a></li>
                                                        <li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="parrent">
                                                <ul class="media-list">
                                                    <li class="post-comment reply">
                                                        <a class="pull-left" href="#">
                                                            <img class="media-object"
                                                                 src="/resource/images/blogdetails/3.png" alt="">
                                                        </a>
                                                        <div class="media-body">
                                                            <span><i class="fa fa-user"></i>Posted by <a
                                                                    href="#">Endure</a></span>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                                                sed do eiusmod tempor incididunt ut </p>
                                                            <ul class="nav navbar-nav post-nav">
                                                                <li><a href="#"><i class="fa fa-clock-o"></i>February
                                                                    11,2014</a></li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="post-comment">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object" src="/resource/images/blogdetails/4.png"
                                                         alt="">
                                                </a>
                                                <div class="media-body">
                                                    <span><i class="fa fa-user"></i>Posted by <a
                                                            href="#">Endure</a></span>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                                        eiusmod tempor incididunt ut labore et dolore magna aliq Ut enim
                                                        ad minim veniam, quis nostrud exercitation ullamco laboris
                                                        nisi.</p>
                                                    <ul class="nav navbar-nav post-nav">
                                                        <li><a href="#"><i class="fa fa-clock-o"></i>February
                                                            11,2014</a></li>
                                                        <li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </li>

                                    </ul>
                                </div><!--/Response-area-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-5">
                <div class="sidebar blog-sidebar">
                    <div class="sidebar-item  recent">
                        <h3>Comments</h3>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="/resource/images/portfolio/project1.jpg" alt=""></a>
                            </div>
                            <div class="media-body">
                                <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                <p>posted on 07 March 2014</p>
                            </div>
                        </div>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="/resource/images/portfolio/project2.jpg" alt=""></a>
                            </div>
                            <div class="media-body">
                                <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                <p>posted on 07 March 2014</p>
                            </div>
                        </div>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="/resource/images/portfolio/project3.jpg" alt=""></a>
                            </div>
                            <div class="media-body">
                                <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                <p>posted on 07 March 2014</p>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar-item categories">
                        <h3>Categories</h3>
                        <ul class="nav navbar-stacked">
                            <li><a href="#">Lorem ipsum<span class="pull-right">(1)</span></a></li>
                            <li class="active"><a href="#">Dolor sit amet<span class="pull-right">(8)</span></a></li>
                            <li><a href="#">Adipisicing elit<span class="pull-right">(4)</span></a></li>
                            <li><a href="#">Sed do<span class="pull-right">(9)</span></a></li>
                            <li><a href="#">Eiusmod<span class="pull-right">(3)</span></a></li>
                            <li><a href="#">Mockup<span class="pull-right">(4)</span></a></li>
                            <li><a href="#">Ut enim ad minim <span class="pull-right">(2)</span></a></li>
                            <li><a href="#">Veniam, quis nostrud <span class="pull-right">(8)</span></a></li>
                        </ul>
                    </div>
                    <div class="sidebar-item tag-cloud">
                        <h3>Tag Cloud</h3>
                        <ul class="nav nav-pills">
                            <li><a href="#">Corporate</a></li>
                            <li><a href="#">Joomla</a></li>
                            <li><a href="#">Abstract</a></li>
                            <li><a href="#">Creative</a></li>
                            <li><a href="#">Business</a></li>
                            <li><a href="#">Product</a></li>
                        </ul>
                    </div>
                    <div class="sidebar-item popular">
                        <h3>Latest Photos</h3>
                        <ul class="gallery">
                            <li><a href="#"><img src="/resource/images/portfolio/popular1.jpg" alt=""></a></li>
                            <li><a href="#"><img src="/resource/images/portfolio/popular2.jpg" alt=""></a></li>
                            <li><a href="#"><img src="/resource/images/portfolio/popular3.jpg" alt=""></a></li>
                            <li><a href="#"><img src="/resource/images/portfolio/popular4.jpg" alt=""></a></li>
                            <li><a href="#"><img src="/resource/images/portfolio/popular5.jpg" alt=""></a></li>
                            <li><a href="#"><img src="/resource/images/portfolio/popular1.jpg" alt=""></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--/#blog-->

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 text-center bottom-separator">
                <img src="/resource/images/home/under.png" class="img-responsive inline" alt="">
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="testimonial bottom">
                    <h2>Testimonial</h2>
                    <div class="media">
                        <div class="pull-left">
                            <a href="#"><img src="/resource/images/home/profile1.png" alt=""></a>
                        </div>
                        <div class="media-body">
                            <blockquote>Nisi commodo bresaola, leberkas venison eiusmod bacon occaecat labore tail.
                            </blockquote>
                            <h3><a href="#">- Jhon Kalis</a></h3>
                        </div>
                    </div>
                    <div class="media">
                        <div class="pull-left">
                            <a href="#"><img src="/resource/images/home/profile2.png" alt=""></a>
                        </div>
                        <div class="media-body">
                            <blockquote>Capicola nisi flank sed minim sunt aliqua rump pancetta leberkas venison
                                eiusmod.
                            </blockquote>
                            <h3><a href="">- Abraham Josef</a></h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="contact-info bottom">
                    <h2>Contacts</h2>
                    <address>
                        E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br>
                        Phone: +1 (123) 456 7890 <br>
                        Fax: +1 (123) 456 7891 <br>
                    </address>

                    <h2>Address</h2>
                    <address>
                        Unit C2, St.Vincent's Trading Est., <br>
                        Feeder Road, <br>
                        Bristol, BS2 0UY <br>
                        United Kingdom <br>
                    </address>
                </div>
            </div>
            <div class="col-md-4 col-sm-12">
                <div class="contact-form bottom">
                    <h2>Send a message</h2>
                    <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" required="required"
                                   placeholder="Email Id">
                        </div>
                        <div class="form-group">
                            <textarea name="message" id="message" required="required" class="form-control" rows="8"
                                      placeholder="Your text here"></textarea>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-submit" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-12">
                <div class="copyright-text text-center">
                    <p>&copy; Your Company 2014. All Rights Reserved.</p>
                    <p>Designed by <a target="_blank" href="http://www.themeum.com">Themeum</a></p>
                </div>
            </div>
        </div>
    </div>
</footer>
<!--/#footer-->


<script type="text/javascript" src="/resource/js/jquery.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/lightbox.min.js"></script>
<script type="text/javascript" src="/resource/js/wow.min.js"></script>
<script type="text/javascript" src="/resource/js/main.js"></script>
</body>
</html>
