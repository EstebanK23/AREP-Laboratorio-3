# AREP - Laboratorio 3

# Autor: Guillermo Esteban Bernal Bonilla

## Profesor: Luis Daniel Benavides Navarro AREP-2021-1

## Viernes 19-Febrero-2021

## Taller Servidores y Clientes.

El objetivo de este proyecto es facilitar la comunicación entre cliente y servidor mediante un servidor http-

## Arquitectura de HttpServer

Este proyecto se construyo utilizando el lenguaje de Java, el editor Apache NetBeans IDE 12.2, Maven para su ejecución y Heroku para realizar su despliegue en la nube.

## Licencia

La licencia utilizada para este proyecto es GPL-3.0 la cual se encuentra especificada en el siguiente enlace

[Licencia](https://github.com/EstebanK23/AREP-Laboratorio-2/blob/main/LICENSE.txt)

## Diseño

![Diagrama](https://user-images.githubusercontent.com/54051399/107119768-b4d16f80-6857-11eb-9e37-6e358ad03cfb.png)

### Descripción del diseño

Como se muestra en la imagen este diseño consta de una fachada que cuenta con una clase principal SparWebApp, esta se encarga de llamar los metodos de la calculadora y de realizar el tanto el front como el despliegue en la aplicación de heroku, también de 3 clases las cuales serán las encargadas de realizar la implementacion de mi LinkedList y el calculo de la media y desviacion estandar para cada archivo leido, como se muestra la clase Calculator obtendra una LinkedList para realizar los calculos, que a su vez la clase LinkedList estara conectada con la clase Node la cual mostrara los nodos y su funcionamiento para la creación de la LinkedList.

## Uso de Http Server

Lo primero que deberas hacer es abrir la terminal de tu ordenador (CMD) y obtener el proyecto que se encuenta en el siguiente enlace:

![Repositorio HttpServer](https://github.com/EstebanK23/AREP-Laboratorio-3)

Para obtener el proyecto deberas clonarlo desde git, el cual ya debe estar instalado como se menciono anteriormente, para esto se usara el siguiente comando en la terminal.

![image](https://user-images.githubusercontent.com/54051399/107120879-6aeb8800-685d-11eb-92c3-604cb0105ed0.png)

El paso siguiente es compilar el proyecto haciendo uso del siguiente comando de Maven.

![image](https://user-images.githubusercontent.com/54051399/107120929-98d0cc80-685d-11eb-9b6b-4a9b49539f20.png)

Al realizar este comando podremos ver los siguente

![image](https://user-images.githubusercontent.com/54051399/107121022-36c49700-685e-11eb-91b6-c9cb2ea64681.png)

## Ejecución de pruebas

Para dar inicio a la ejecucion de pruebas se utilizara el siguiente comando de Maven.

![image](https://user-images.githubusercontent.com/54051399/107121043-522fa200-685e-11eb-8edd-9d6e49a41210.png)

Esto nos mostrará la ejecución de pruebas de la calculadora con datos ingresados en el programa

Tambien cada una de las funcionalidades implementadas del LinkedList

![image](https://user-images.githubusercontent.com/54051399/107121156-eef23f80-685e-11eb-8b9b-8ca3ee8866be.png)

Para ver el despliegue se usa este comando

![image](https://user-images.githubusercontent.com/54051399/107121173-029da600-685f-11eb-911a-7c86c2bffd72.png)

Otra forma es acceder a este link **(Deploy in Heroku)**

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://stark-inlet-93694.herokuapp.com/data)

Aca se muestra el sistema de integración continua **(Circle Ci)**

[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/EstebanK23/AREP-Laboratorio-2)

Por ultimo mostramos las pruebas de que el despligue funciona perfectamente en heroku.

![image](https://user-images.githubusercontent.com/54051399/107121228-4395ba80-685f-11eb-9ba3-afbf8055103a.png)

![image](https://user-images.githubusercontent.com/54051399/107121249-67590080-685f-11eb-8768-2408bcbe464c.png)
