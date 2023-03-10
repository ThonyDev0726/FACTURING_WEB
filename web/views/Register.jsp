<%-- 
    Document   : index
    Created on : 8 ago. 2022, 12:58:02
    Author     : perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html oncontextmenu="return false">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--==================== UNICONS ====================-->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v3.0.6/css/line.css">

        <!--==================== SWIPER CSS====================-->
        <link rel="stylesheet" href="css/swiper-bundle.min.css">
        <!--==================== CSS ==========-->
        <link href="css/Register.css" rel="stylesheet" type="text/css"/>
        <link href="css/loader.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/notebooks.svg"/>
        <!--JS GOOGLE ADSENSE-->
        <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9905043953454458"
        crossorigin="anonymous"></script>
        <title>FACTURING</title>
    </head>
    <body>
        <div class="loader_bg">
            <div class="loader"></div>
        </div>
        <!--==================== HEADER ====================-->
        <header class="header" id="header">
            <nav class="nav container">
                <a href="Controller?accion=main" class="nav__logo"><i class="uil uil-notebooks button__icon"></i> FACTURING</a>

                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list grid">
                        
                        <li class="nav__item">
                            <a href="Controller?accion=main#contact" class="nav__link">
                                <i class="uil uil-message nav__icon"></i> Contactanos
                            </a>
                        </li>
                        
                        <li class="nav__item">
                            <a href="Controller?accion=iniciar-sesion" class="nav__link">
                                <i class="uil uil-user nav__icon"></i> Iniciar sesion
                            </a>
                        </li>
                    </ul>
                    <i class="uil uil-times nav__close" id="nav-close"></i>
                </div>

                <div class="nav__btns">
                    <!--Theme change button -->                    
                    <i class="uil uil-moon change-theme" id="theme-button"></i>

                    <div class="nav__toggle" id="nav-toggle">
                        <i class="uil uil-apps"></i>
                    </div>
                </div>
            </nav>
        </header>

        <!--==================== MAIN ====================-->
        <main class="main">
            <!--==================== HOME ====================-->
            <section class="home section" id="home">
                <div class="home__container container grid">
                    <div class="home__content grid">
                        <div class="home__social">

                            <a href="https://github.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-facebook-f"></i>
                            </a>

                            <a href="https://dribbble.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-instagram"></i>
                            </a>

                            <a href="https://www.linkedin.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-linkedin-alt"></i>
                            </a>

                        </div>

                        <div class="home__img">
                            <img src="https://drive.google.com/uc?export=download&id=17xgsBG92LBukV5EPP3rKLoKEz_dXYeHt" width="25" height="25" class="home__blob-img"  alt="">

                        </div>

                        <div class="home__data">
                            <h1 class="home__title">Registrame</h1>
                            <div class="contact__content">
                                <label for="" class="contact__label">Nombre de usuario:</label>
                                <input type="text" class="contact__input">
                            </div>
                            <br>
                            <div class="contact__content">
                                <label for="" class="contact__label">Contrase??a:</label> 
                                <input type="password" class="contact__input">
                            </div>
                            <br>
                            <div class="contact__content">
                                <label for="" class="contact__label">Cedula:</label> 
                                <input type="number" class="contact__input">
                            </div>
                            <br>
                            <div class="contact__content">
                                <label for="" class="contact__label">Email:</label> 
                                <input type="email" class="contact__input">
                            </div>
                            <br>
                            <a href="Controller?accion=iniciar-sesion" class="button button--flex">
                                Registrarme <i class="uil uil-message button__icon"></i>
                            </a>
                        </div>
                    </div>


                </div>
            </section>

        </main>
        <!--==================== FOOTER ====================-->


        <!--========== SCROLL TOP ==========-->
        <a href="#" class="scrollup" id="scroll-top">
            <i class="uil uil-arrow-up scrollup__icon"></i>
        </a>

        <!--==================== SWIPER JS ====================-->
        <script src="js/swiper-bundle.min.js"></script>

        <!--==================== MAIN JS ====================-->       
        <script src="js/main.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="js/loader.js" type="text/javascript"></script>
        <script type="module">

            // Import the functions you need from the SDKs you need

            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.0/firebase-app.js";

            import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.9.0/firebase-analytics.js";

            // TODO: Add SDKs for Firebase products that you want to use

            // https://firebase.google.com/docs/web/setup#available-libraries


            // Your web app's Firebase configuration

            // For Firebase JS SDK v7.20.0 and later, measurementId is optional

            const firebaseConfig = {

                apiKey: "AIzaSyC2Ph6vWOrtQ5vPg-Qgt2bRhgUfSNesVUI",

                authDomain: "anthony-e3ad6.firebaseapp.com",

                projectId: "anthony-e3ad6",

                storageBucket: "anthony-e3ad6.appspot.com",

                messagingSenderId: "68135577160",

                appId: "1:68135577160:web:92b7f15ee019aec48d1a7d",

                measurementId: "G-QFS7MXE37E"

            };


            // Initialize Firebase

            const app = initializeApp(firebaseConfig);

            const analytics = getAnalytics(app);

        </script>
    </body>
</html>
