[![Build Status](https://travis-ci.org/Algoritmos-3-FIUBA/TP2.svg?branch=master)](https://travis-ci.org/Algoritmos-3-FIUBA/TP2)
[![codecov](https://codecov.io/gh/Algoritmos-3-FIUBA/TP2/branch/master/graph/badge.svg)](https://codecov.io/gh/Algoritmos-3-FIUBA/TP2)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)



# TP2 Algoritmos 3: Kahoot

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo 4

* **Giardina, Fernando** - [FerGiardina](https://github.com/FerGiardina)
* **Panaccio, Guido** - [Guido-Panaccio](https://github.com/Guido-Panaccio)
* **Rotondo, Matías** - [MatiasRotondo](https://github.com/MatiasRotondo)
* **Stenghele, Juan** - [JuanStenghele](https://github.com/JuanStenghele)
* **Waisten, Lucas** - [LucasWaisten](https://github.com/LucasWaisten)

Corrector: **Pablo Suárez**

## Instalación previa

Las únicas herramientas necesarias para trabajar en el proyecto son el entorno de desarrollo de Java ([JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)), [Apache Maven](https://maven.apache.org) para la construcción automatizada y Git para el control de versiones.

```console
$ sudo apt update
$ sudo apt install default-jdk maven git
```

Verificamos que se hayan instalado correctamente:

```console
$ javac -version
javac 11.0.4
$ mvn --version
Apache Maven 3.6.0
Maven home: /usr/share/maven
Java version: 11.0.4, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: es_AR, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-66-generic", arch: "amd64", family: "unix"
$ git --version
git version 2.17.1
```

## Ejecutando las pruebas

```bash
    mvn test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

Explicación de como ejecutar la aplicación

## Licencia

Este repositorio está bajo la Licencia MIT
