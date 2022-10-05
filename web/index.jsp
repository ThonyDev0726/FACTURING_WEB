<%-- 
    Document   : index
    Created on : 8 ago. 2022, 12:58:02
    Author     : perez
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

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
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
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

        <%
            //EMPRESA_DAO dao = new EMPRESA_DAO();
            //EMPRESA usu = (EMPRESA) dao.list();
        %>
        <!--==================== HEADER ====================-->
        <header class="header" id="header">
            <nav class="nav container">
                <a href="#" class="nav__logo">
                    FACTURING
                </a>

                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list grid">
                        <li class="nav__item">
                            <a href="#home" class="nav__link active-link">
                                <i class="uil uil-estate nav__icon"></i> Inicio
                            </a>
                        </li>



                        <li class="nav__item">
                            <a href="#skills" class="nav__link">
                                <i class="uil uil-file-alt nav__icon"></i> Experiencia
                            </a>
                        </li>

                        <li class="nav__item">
                            <a href="#services" class="nav__link">
                                <i class="uil uil-briefcase-alt nav__icon"></i> Servicios
                            </a>
                        </li>

                        <li class="nav__item">
                            <a href="#contact" class="nav__link">
                                <i class="uil uil-message nav__icon"></i> Contactanos
                            </a>
                        </li>

                        <li class="nav__item">
                            <a href="Controller?accion=registro" class="nav__link">
                                <i class="uil uil-user-plus nav__icon"></i> Registrame
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
                            <a href="https://facebook.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-facebook-f"></i>
                            </a>                           
                            <a href="https://twitter.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-twitter"></i>
                            </a>
                            <a href="https://instagram.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-instagram"></i>
                            </a>
                            <a href="https://www.tiktok.com/" target="_blank" class="home__social-icon">
                                <i class="uil uil-music-note"></i>
                            </a>
                        </div>
                        <div class="home__img">
                            

                            <!--==================== 
                                    Insert your image in the Img folder and Change your image |
                                    Center your image with X: horizontal, Y: vertical 
                                ====================-->
                            <img src="https://drive.google.com/uc?export=download&id=17xgsBG92LBukV5EPP3rKLoKEz_dXYeHt" width="25" height="25" class="home__blob-img"  alt="">

                        </div>

                        <div class="home__data">
                            <h1 class="home__title">Bienvenido,</h1>
                            <h3 class="home__subtitle">al sistema <b>Facturing</b></h3>
                            <p class="home__description"> Aqui vas a poder gestionar la distribucion de los productos a cualquier hora y en cualquier lugar.</p>
                            <a href="Controller?accion=iniciar-sesion" class="button button--flex">
                                Iniciar Sesion <i class="uil uil-message button__icon"></i>
                            </a>
                        </div>
                    </div>
                    <div class="home__scroll">
                        <a href="#about" class="home__scroll-button button--flex">
                            <i class="uil uil-mouse-alt home__scroll-mouse"></i>
                            <span class="home__scroll-name">Saber mas</span>
                            <i class="uil uil-arrow-down home__scroll-arrow"></i>
                        </a>
                    </div>
                </div>
            </section>

            <!--==================== ABOUT ====================-->
            <section class="about section" id="about">
                <h2 class="section__title">Sobre el sistema</h2>
                <span class="section__subtitle">Introduction</span>

                <div class="about__container container grid">
                    <img src="img/about.jpg" alt="" class="about__img">

                    <div class="about__data">
                        <p class="about__description">Sistema, netamente responsivo y adpatado a los 
                            requerimientos de una bliblioteca, con una gestion impecable.
                        </p>

                        <div class="about__info">
                            <div>
                                <span class="about__info-title uil uil-shield-check"></span>
                                <span class="about__info-name">Ultra <br> seguridad</span>
                            </div>

                            <div>
                                <span class="about__info-title"><i class="uil uil-map-marker-alt"></i></span>
                                <span class="about__info-name">Donde <br> quieras</span>
                            </div>

                            <div>
                                <span class="about__info-title"><i class="uil uil-clock-five"></i></span>
                                <span class="about__info-name">A la hora <br> que quieras</span>
                            </div>
                        </div>

                        <div class="about__buttons">
                            <!--==================== Change your CV ====================-->
                            <a download="" href="assets/pdf/Alexa-Cv.pdf" class="button button--flex">
                                Leer reseña <i class="uil uil-download-alt button__icon"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </section>

            <!--==================== SKILLS ====================-->
            <!--==================== SERVICES ====================-->
            <section class="services section" id="services">
                <h2 class="section__title">Servicios</h2>
                <span class="section__subtitle">Nosotros ofertamos</span>

                <div class="services__container container grid">
                    <!--=============== SERVICIOS ===============-->
                    <div class="services__content">
                        <div>
                            <h3 class="services__title  services__button">Ui/Ux Designer</h3>
                        </div>                      

                        <div class="services__modal">
                            <div class="services__modal-content">
                                <h4 class="services__modal-title">Ui/Ux <br> Designer</h4>
                                <i class="uil uil-times services__modal-close"></i>

                                <ul class="services__modal-services grid">
                                    <li class="services__modal-service">
                                        <i class="uil uil-check-circle services__modal-icon"></i>
                                        <p>I develop the user interface.</p>
                                    </li>
                                    <li class="services__modal-service">
                                        <i class="uil uil-check-circle services__modal-icon"></i>
                                        <p>Web page development.</p>
                                    </li>
                                    <li class="services__modal-service">
                                        <i class="uil uil-check-circle services__modal-icon"></i>
                                        <p>I create ux element interactions.</p>
                                    </li>
                                    <li class="services__modal-service">
                                        <i class="uil uil-check-circle services__modal-icon"></i>
                                        <p>I position your company brand.</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>                    
                </div>
            </section>
            <!--==================== QUALIFICATION ====================-->
            <section class="qualification section" id="skills">
                <h2 class="section__title">Datos extra</h2>

                <div class="qualification__container container">
                    <div class="qualification__tabs">
                        <div class="qualification__button button--flex qualification__active" data-target="#education">
                            <i class="uil uil-graduation-cap qualification__icon"></i> Reconocimientos
                        </div>

                        <div class="qualification__button button--flex" data-target="#work">
                            <i class="uil uil-briefcase-alt qualification__icon"></i> Experiencia
                        </div>
                    </div>

                    <div class="qualification__sections">
                        <!--=============== QUALIFICATION CONTENT 1 ===============-->
                        <div class="qualification__content qualification__active" data-content id="education">
                            <!--=============== QUALIFICATION 1 ===============-->
                            <div class="qualification__data">
                                <div>
                                    <h3 class="qualification__title">Computer Engineer</h3>
                                    <span class="qualification__subtitle">Peru - University</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2009 - 2014
                                    </div>
                                </div>

                                <div>
                                    <span class="qualification__rounder"></span>
                                    <span class="qualification__line"></span>
                                </div>
                            </div>

                            <!--=============== QUALIFICATION 2 ===============-->
                            <div class="qualification__data">
                                <div></div>

                                <div>
                                    <span class="qualification__rounder"></span>
                                    <span class="qualification__line"></span>
                                </div>

                                <div>
                                    <h3 class="qualification__title">Web Design</h3>
                                    <span class="qualification__subtitle">Spain - Institute</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2014 - 2017
                                    </div>
                                </div>
                            </div>

                            <!--=============== QUALIFICATION 3 ===============-->
                            <div class="qualification__data">
                                <div>
                                    <h3 class="qualification__title">Web Development</h3>
                                    <span class="qualification__subtitle">Peru - Institute</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2017 - 2019
                                    </div>
                                </div>

                                <div>
                                    <span class="qualification__rounder"></span>
                                    <span class="qualification__line"></span>
                                </div>
                            </div>

                            <!--=============== QUALIFICATION 4 ===============-->
                            <div class="qualification__data">
                                <div></div>

                                <div class="qualification__time">
                                    <span class="qualification__rounder"></span>
                                    <!-- <span class="qualification__line"></span> -->
                                </div>

                                <div>
                                    <h3 class="qualification__title">Master in Ui/Ux</h3>
                                    <span class="qualification__subtitle">Peru - Institute</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2019 - 2021
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--=============== QUALIFICATION CONTENT 2 ===============-->
                        <div class="qualification__content" data-content id="work">
                            <!--=============== QUALIFICATION 1 ===============-->
                            <div class="qualification__data">
                                <div>
                                    <h3 class="qualification__title">Software Engineer</h3>
                                    <span class="qualification__subtitle">Microsoft - Peru</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2016-2018
                                    </div>
                                </div>

                                <div>
                                    <span class="qualification__rounder"></span>
                                    <span class="qualification__line"></span>
                                </div>
                            </div>

                            <!--=============== QUALIFICATION 2 ===============-->
                            <div class="qualification__data">
                                <div></div>

                                <div class="qualification__time">
                                    <span class="qualification__rounder"></span>
                                    <span class="qualification__line"></span>
                                </div>

                                <div>
                                    <h3 class="qualification__title">Frontend Developer</h3>
                                    <span class="qualification__subtitle">Apple Inc - Spain</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2018-2020
                                    </div>
                                </div>
                            </div>

                            <div class="qualification__data">
                                <div>
                                    <h3 class="qualification__title">Ui Designer</h3>
                                    <span class="qualification__subtitle">Figma - Spain</span>
                                    <div class="qualification__calendar">
                                        <i class="uil uil-calendar-alt"></i> 2020-2021
                                    </div>
                                </div>

                                <div>
                                    <span class="qualification__rounder"></span>
                                    <!-- <span class="qualification__line"></span> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>




            <!--==================== PORTFOLIO ====================-->
            <section class="portfolio section" id="portfolio">
                <h2 class="section__title">Eventos</h2>
                <span class="section__subtitle">Proximamente</span>

                <div class="portfolio__container container swiper-container">
                    <div class="swiper-wrapper">
                        <!--=============== PORTFOLIO 1 ===============-->
                        <div class="portfolio__content grid swiper-slide">
                            <img src="img/portfolio1.jpg" alt="" class="portfolio__img">

                            <div class="portfolio__data">
                                <h3 class="portfolio__title">Evento</h3>
                                <p class="portfolio__description">El sabado 30 de febrero del presente año se va allevar a cabo
                                    un evento sumamente importante.</p>
                                <a href="#" class="button button--flex button--small portfolio__button">
                                    Ver
                                    <i class="uil uil-arrow-right button__icon"></i>
                                </a>
                            </div>
                        </div>

                        <!--=============== PORTFOLIO 2 ===============-->
                        <div class="portfolio__content grid swiper-slide">
                            <img src="img/portfolio2.jpg" alt="" class="portfolio__img">

                            <div class="portfolio__data">
                                <h3 class="portfolio__title">Evento 2</h3>
                                <p class="portfolio__description">El sabado 30 de febrero del presente año se va allevar a cabo
                                    un evento sumamente importante.</p>
                                <a href="#" class="button button--flex button--small portfolio__button">
                                    Ver
                                    <i class="uil uil-arrow-right button__icon"></i>
                                </a>
                            </div>
                        </div>

                        <!--=============== PORTFOLIO 3 ===============-->
                        <div class="portfolio__content grid swiper-slide">
                            <img src="img/portfolio3.jpg" alt="" class="portfolio__img">

                            <div class="portfolio__data">
                                <h3 class="portfolio__title">Evento 3</h3>
                                <p class="portfolio__description">El sabado 30 de febrero del presente año se va allevar a cabo
                                    un evento sumamente importante.</p>
                                <a href="#" class="button button--flex button--small portfolio__button">
                                    Ver
                                    <i class="uil uil-arrow-right button__icon"></i>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-button-next">
                        <i class="uil uil-angle-right-b swiper-portfolio-icon"></i>
                    </div>
                    <div class="swiper-button-prev">
                        <i class="uil uil-angle-left-b swiper-portfolio-icon"></i>
                    </div>

                    <div class="swiper-pagination"></div>
                </div>
            </section>

            <!--==================== PROJECT IN MIND ====================-->
            <section class="project section">
                <div class="project__bg">
                    <div class="project__container container grid">
                        <div class="project__data">
                            <h2 class="project__title">Tienes un nuevo proyecto?</h2>
                            <p class="project__description">Contáctame ahora y obtén un 30% de descuento en tu nuevo proyecto.</p>
                            <a href="#contact" class="button button--flex button--white">
                                Contactanos!
                                <i class="uil uil-message button__icon"></i>
                            </a>
                        </div>

                        <img src="img/project.png" alt="" class="project__img">
                    </div>
                </div>
            </section>

            <!--==================== TESTIMONIAL ====================-->
            <section class="testimonial section">
                <h2 class="section__title">Testimoniales</h2>
                <span class="section__subtitle">Nuestros clientes dicen</span>

                <div class="testimonial__container container swiper-container">
                    <div class="swiper-wrapper">
                        <!--=============== TESTIMONIAL 1 ===============-->
                        <div class="testimonial__content swiper-slide">
                            <div class="testimonial__data">
                                <div class="testimonial__header">
                                    <img src="img/testimonial1.jpg" alt="" class="testimonial__img">

                                    <div>
                                        <h3 class="testimonial__name">Sara Smith</h3>
                                        <span class="testimonial__client">Cliente</span>
                                    </div>
                                </div>

                                <div>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                </div>
                            </div>

                            <p class="testimonial__description">Tengo una buena impresión, realizo mi proyecto con todas las
                                calidad posible y atención y soporte las 24 horas del día.
                            </p>
                        </div>

                        <!--=============== TESTIMONIAL 2 ===============-->
                        <div class="testimonial__content swiper-slide">
                            <div class="testimonial__data">
                                <div class="testimonial__header">
                                    <img src="img/testimonial2.jpg" alt="" class="testimonial__img">

                                    <div>
                                        <h3 class="testimonial__name">Matt Robinson</h3>
                                        <span class="testimonial__client">Cliente</span>
                                    </div>
                                </div>

                                <div>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                </div>
                            </div>

                            <p class="testimonial__description">Tengo una buena impresión, realizo mi proyecto con todas las
                                calidad posible y atención y soporte las 24 horas del día.
                            </p>
                        </div>

                        <!--=============== TESTIMONIAL 3 ===============-->
                        <div class="testimonial__content swiper-slide">
                            <div class="testimonial__data">
                                <div class="testimonial__header">
                                    <img src="img/testimonial3.jpg" alt="" class="testimonial__img">

                                    <div>
                                        <h3 class="testimonial__name">Raul Harris</h3>
                                        <span class="testimonial__client">Cliente</span>
                                    </div>
                                </div>

                                <div>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                    <i class="uil uil-star testimonial__icon-star"></i>
                                </div>
                            </div>

                            <p class="testimonial__description">Tengo una buena impresión, realizo mi proyecto con todas las
                                calidad posible y atención y soporte las 24 horas del día.
                            </p>
                        </div>
                    </div>
                    <div class="swiper-pagination swiper-pagination-testimonial"></div>
                </div>
            </section>

            <!--==================== CONTACT ME ====================-->
            <section class="contact section" id="contact">
                <h2 class="section__title">Contactanos</h2>
                <span class="section__subtitle">con un toque</span>

                <div class="contact__container container grid">
                    <div>
                        <div class="contact__information">
                            <i class="uil uil-phone contact__icon"></i>
                            <div>
                                <h3 class="contact__title">Llamanos</h3>
                                <span class="contact__subtitle">098-868-422</span>
                            </div>
                        </div>

                        <div class="contact__information">
                            <i class="uil uil-envelope contact__icon"></i>
                            <div>
                                <h3 class="contact__title">Email</h3>
                                <span class="contact__subtitle">HORUS@email.com</span>
                            </div>
                        </div>

                        <div class="contact__information">
                            <i class="uil uil-map-marker contact__icon"></i>
                            <div>
                                <h3 class="contact__title">Locacion</h3>
                                <span class="contact__subtitle">Ecuador - Quito Av. Guayanay #123</span>
                            </div>
                        </div>
                    </div>

                    <form action="" class="contact__form grid">
                        <div class="contact__inputs grid">
                            <div class="contact__content">
                                <label for="" class="contact__label">Nombre</label>
                                <input type="text" class="contact__input">
                            </div>
                            <div class="contact__content">
                                <label for="" class="contact__label">Email</label>
                                <input type="email" class="contact__input">
                            </div>
                        </div>
                        <div class="contact__content">
                            <label for="" class="contact__label">Proyecto</label>
                            <input type="text" class="contact__input">
                        </div>
                        <div class="contact__content">
                            <label for="" class="contact__label">Mensaje</label>
                            <textarea name="" id="" cols="0" rows="7" class="contact__input"></textarea>
                        </div>

                        <div>
                            <a href="#" class="button button--flex">
                                Enviar mensaje
                                <i class="uil uil-message button__icon"></i>
                            </a>
                        </div>
                    </form>
                </div>

            </section>
        </main>

        <!--==================== FOOTER ====================-->
        <footer class="footer">
            <div class="footer__bg">
                <div class="footer__container container grid">
                    <div>
                        <h1 class="footer__title">HORUS</h1>
                        <span class="footer__subtitle">HORUS de alto nivel</span>
                    </div>

                    <ul class="footer__links">
                        <li>
                            <a href="#services" class="footer__link">Servicios</a>
                        </li>
                        <li>
                            <a href="#portfolio" class="footer__link">Eventos</a>
                        </li>
                        <li>
                            <a href="#contact" class="footer__link">Contactanos</a>
                        </li>
                    </ul>

                    <div class="footer__socials">
                        <a href="https://www.facebook.com/" target="_blank" class="footer__social">
                            <i class="uil uil-facebook-f"></i>
                        </a>
                        <a href="https://www.instagram.com/" target="_blank" class="footer__social">
                            <i class="uil uil-instagram"></i>
                        </a>
                        <a href="https://twitter.com/" target="_blank" class="footer__social">
                            <i class="uil uil-twitter-alt"></i>
                        </a>
                    </div>
                </div>

                <p class="footer__copy">&#169; HORUS. Todos los derechos reservados</p>
            </div>
        </footer>

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
