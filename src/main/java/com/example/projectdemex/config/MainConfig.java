package com.example.projectdemex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MainConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${mail.debug}")
    private String debug;

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);

        return mailSender;
    }
}
/*<!DOCTYPE html>
<html lang="ru">
<div th:replace="~{fragments/head_fragment :: head(pageTitle='Регистрация')}"></div>
<body>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-6 col-sm-8 col-10 mt-5">
            <form method="post" th:action="@{/registration}" th:object="${userDto}" class="p-4 shadow-lg rounded needs-validation">
                <h2 class="text-center mb-4">Регистрация</h2>
                <div class="mb-3">
                    <label for="name" class="form-label">Имя:</label>
                    <input class="form-control" type="text" placeholder="Введите имя" th:field="*{name}" id="name" aria-describedby="nameHelp"/>
                    <div id="nameHelp" class="form-text">Примеры имени: Владислав, Олег, John, Joe</div>
                    <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}" class="text-danger">Ошибка имени</span>
                </div>
                <div class="mb-3">
                    <label for="surname" class="form-label">Фамилия:</label>
                    <input class="form-control" type="text" placeholder="Введите фамилию" th:field="*{surname}" id="surname" aria-describedby="surnameHelp"/>
                    <div id="surnameHelp" class="form-text">Примеры фамилии: Иванов, Петров, Gonzales, Alvarez</div>
                    <span th:if="${#fields.hasErrors('surname')}" th:errors="*{surname}" class="text-danger">Ошибка имени</span>
                </div>
                <div class="mb-3">
                    <label for="username_reg" class="form-label">Логин:</label>
                    <input class="form-control" type="text" placeholder="Введите логин" th:field="*{username}"
                           id="username_reg" aria-describedby="usernameHelp"/>
                    <span th:if="${#fields.hasErrors('username')}" th:errors="*{username}" class="text-danger">Ошибка имени</span>
                    <div id="usernameHelp" class="form-text">Примеры логина: лимон1724, atomic2020, Самурай11</div>
                </div>
                <div class="mb-3">
                    <label for="password_reg" class="form-label">Пароль:</label>
                    <input class="form-control" type="password" placeholder="Введите пароль" th:field="*{password}"
                           id="password_reg"/>
                    <span th:if="${#fields.hasErrors('password')}" th:errors="*{password}" class="text-danger">Ошибка имени</span>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Почта:</label>
                    <input class="form-control" type="email" placeholder="Введите почту" th:field="*{email}" id="email" aria-describedby="emailHelp"/>
                    <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}" class="text-danger">Ошибка имени</span>
                    <div id="emailHelp" class="form-text">Примеры почты: example@example.com, user123@mail.ru, john.doe@company.co.uk</div>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Номер телефона:</label>
                    <input class="form-control" type="text" placeholder="+7(000)000-00-00" th:field="*{phone}"
                           id="phone"/>
                </div>
                <div class="d-grid gap-2">
                    <button type="button" class="btn btn-secondary" onclick="onBack()">Вернуться</button>
                    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
                </div>
            </form>
        </div>
    </div>
</div>
<th:block th:replace="~{/fragments/script_fragment :: scripts}"></th:block>
</body>
</html> в чем ошибка Cannot resolve 'name'
Cannot resolve 'surname'
Cannot resolve 'username'
*/
/*
<div class="mb-3">
    <label for="name" class="form-label">Имя:</label>
    <input class="form-control" type="text" placeholder="Введите имя" th:field="*{name}" id="name" aria-describedby="nameHelp"/>
    <div id="nameHelp" class="form-text">Примеры имени: Владислав, Олег, John, Joe</div>
    <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}" class="text-danger"></span>
</div>
<div class="mb-3">
    <label for="surname" class="form-label">Фамилия:</label>
    <input class="form-control" type="text" placeholder="Введите фамилию" th:field="*{surname}" id="surname" aria-describedby="surnameHelp"/>
    <div id="surnameHelp" class="form-text">Примеры фамилии: Иванов, Петров, Gonzales, Alvarez</div>
    <span th:if="${#fields.hasErrors('surname')}" th:errors="*{surname}" class="text-danger"></span>
</div>
<div class="mb-3">
    <label for="username_reg" class="form-label">Логин:</label>
    <input class="form-control" type="text" placeholder="Введите логин" th:field="*{username}" id="username_reg" aria-describedby="usernameHelp"/>
    <span th:if="${#fields.hasErrors('username')}" th:errors="*{username}" class="text-danger"></span>
    <div id="usernameHelp" class="form-text">Примеры логина: лимон1724, atomic2020, Самурай11</div>
</div>*/
