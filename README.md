# Readme Proyecto Automatización

## Clonar el repositirio

Para clonar el repositorio y comenzar a trabajar desde su ambiente local deberá seguir los siguientes pasos:

### Linux/macOSX

1.  Desde la terminal ir a:
cd ~/.ssh

Si el directorio no existe debe generarlo:
mkdir ~/.ssh
2. Si el directorio ya existía, debe validar la existencia de otras llaves con:
   ls id_*
3. Si ya tenía llaves generadas deberá respaldarlas con lo siguiente:
   cp id_rsa* key_backup
4. Genere una nueva llave con su mail de acuerdo lo siguiente:
   ssh-keygen -t rsa -C "su_correo@gmail.com"
5. Una vez generada la llave, deberá copiar el contenido con lo siguiente:
   more ~/.ssh/id_rsa.pub
6. Luego debe ir a su cuenta github
   => icono Ajuste => ssh and GCP keys => nueva llave ssh (new shh key)

   Ahí deberán pegar el contenido mostrado por el archivo id_rsa.pub descrito en el paso anterior o copiar con el siguiente comando:
   pbcopy < ~/.ssh/id_rsa.pub

   Clic en añadir llave (Add key) para finalizar.
7. Ahora podrá clonar el proyecto:
   git clone ssh://git@coderepocsa.apps.com:7999/elvt/proyectobase.git

### Windows

    1.  Desde la terminal o cmd.exe ir a:
    cd %HOMEPATH%/.ssh

    Si el directorio no existe debe generarlo:
    cd %HOMEPATH%
    mkdir .ssh

2.  Si el directorio ya existía, debe validar la existencia de otras llaves con:
    dir id_*

3.  Si ya tenía llaves generadas deberá respaldarlas con lo siguiente:
    cp id_rsa* key_backup

4.  Genere una nueva llave con su mail de acuerdo lo siguiente:
    ssh-keygen -t rsa -C "su_correo@gmail.com"

5.  Una vez generada la llave, deberá copiar el contenido con lo siguiente:
    cd %HOMEPATH%/.ssh
    more id_rsa.pub

6.  Luego debe ir a su cuenta github 
    => icono Ajuste => ssh and GCP keys => nueva llave ssh (new shh key)
  
    Ahí deberán pegar el contenido mostrado por el archivo id_rsa.pub descrito en el paso anterior o copiar con el siguiente comando:
    cd %HOMEPATH%/.ssh
    more id_rsa.pub | cl

    Clic en añadir llave (Add key) para finalizar.

7.  Ahora podrá clonar el proyecto:
    git clone ssh://git@coderepocsa.apps.com:7999/elvt/proyectobase.git
## Configuración Inicial Ambiente

### Setup Ambiente Desarrollo

- Install [JDK 8](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html)
- Install [Maven](https://maven.apache.org/install.html)

*¿Cómo puedo crear mi propio test?*

*1. FEATURES:* Primero debes tener tu archivo .feature y guardarlo en la ruta correspondiente:

* Desktop: `src/test/java/features/` aquí deben ir todos nuestros .feature y cada archivo .feature, debe tener definido el tag *@test* al inicio de este.

*2. STEPS DEFINITION:* Luego debes revisar si nuestros steps definidos en el archivo .feature se encuentran implementados.
Si no está la implementación de nuestro step, ve a la siguiente ruta, según corresponda y debes crear la definición de tu step. (esto puede sonar raro, pero es donde realizamos la conexión entre el gherkins y el método que va a ejecutar)

* Desktop: `~src/test/java/steps/`

Ejemplo:

@Given("user enters the site")
public void enterTheSite()  {
home.closePopUp();
}

*IMPORTANTE:* si vas a crear un nuevo archivo para Step Definition, el nombre debe tener la siguiente forma NombreDigno*Steps*.java
[Más información sobre Step Definition aquí](https://docs.cucumber.io/cucumber/step-definitions/)

*3. PAGES Y ACTIONS:* Finalmente, para tener organizada la interacción entre los elementos de nuestra página a probar y
las acciones que vamos a realizar, decidimos dividir las acciones y los elementos, es decir, existe una clase en donde se va a definir
todos los elementos que se va a utilizar y existe otra clase que se encarga de interactuar con ese elemento
( realizar un click, validar un texto, ingresar texto, etc.)

La organización es simple, si tienes una página por ejemplo home, creas una carpeta dentro de la ruta correspondiente (action) y dentro de esta
creas la clase  HomeActions.java y otra carpeta (pages) donde se crea la clase HomePage.java y **si existe, la carpeta o las clases solo debes agregar tu código

* Desktop: `~src/test/java/pom/`

*IMPORTANTE:* si vas a crear un nuevo archivo para una page o action, el nombre debe tener la siguiente forma NombrePaginaPage.java y NombrePaginaActions*.java

### Running the tests

Ejemplo:

```
Dirigirse a la carpeta: src => test => java => runner => Runner.Java

Una vez allí, seleccionar el tags que desea correr. 
Sin embargo por defecto trae el tags test, si presiona segundo click, luego run, se ejecutarán todos los test creados.

Si desea ejecutar un solo test, solo se debe cambiar el tags por el de preferencia.
```
### Tags en Cucumber Features

tags = {“@addProducts”} Se ejecutan todos los escenarios bajo este tag.

tags = {“@deleteProducts”} Se ejecuta el escenario de registrar un usuario.

tags = {“@placeOrder”} Se ejecuta el escenario de hacer un login con un usuario.

tags = {“@test”} Se ejecuta el escenario de realizar una compa y validar el precio

## Recursos de Apoyo

##### [Cucumber Docs](https://cucumber.io/docs)

##### [Cucumber School Lessons](https://cucumber.io/school#lessons)

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [Junit Documentation](http://junit.org/javadoc/latest/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)

##### [Stack Overflow](http://stackoverflow.com/)

##### [Jenkins/CloudBees](https://www.jenkins.io/)
