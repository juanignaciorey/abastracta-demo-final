# Abstracta demo final

[![Java CI with Maven](https://github.com/juanignaciorey/abastracta-demo-final/actions/workflows/maven.yml/badge.svg)](https://github.com/juanignaciorey/abastracta-demo-final/actions/workflows/maven.yml)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)


# Selenium Cucumber TestNG Maven
Uploading automation testing framework built using Selenium-Cucumber-TestNG-Maven-WebdriverManager. 

# This framework consists of:
- [_] Java
- [_] TestNG
- [_] Maven
- [_] Selenium
- [_] Cucumber
- [_] WebdriverManager

## Perform the following steps:
1. Abrir web de http://opencart.abstracta.us/ (Puede utilizar cualquier navegador).
2. En la barra de búsqueda, ingresar el producto “iPhone” y buscar.
3. Seleccionar la primera opción que aparezca.
4. Agregar el producto al carrito de compras.
5. Ingresar al botón del carrito de compras.
6. Presionar "View Cart".
7. Validar que el iPhone seleccionado se encuentre en el carrito de compras.
8. Remover el iPhone del carrito de compras.
9. Validar que el iPhone ya no se encuentre en el carrito de compras.
10. Subir proyecto a un pipeline de integración continua (Jenkins, Gitlab CI, etc) y ejecutar el job.
11. Aplicación del patrón de diseño “Page Object”.

## In case of failure, the following steps will be screenshotted
- Agregar el producto al carrito de compras.
- Validar que el iPhone seleccionado se encuentre en el carrito de compras.
- Validar que el iPhone ya no se encuentre en el carrito de compras.


# About:
This project repository is for the Abstracta platform exam.

# How To Run It
```
git clone https://github.com/juanignaciorey/abastracta-demo-final.git
cd ./abastracta-demo-final
mvn test
```

## Running
![Descripción de la imagen](/assets/Screenshot_1.png "running example")

## CI with Github Actions
![Descripción de la imagen](/assets/GitActions-CI-Test.png "run test")
Ex. [latest report](https://github.com/juanignaciorey/abastracta-demo-final/actions/runs/4110666333/jobs/7093709463)

