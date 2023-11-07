# AE-2.-Servicios-REST
SpringBoot + Rest que tiene como objetivo simular una api de una biblioteca

Objetivos
Aprender a usar la arquitectura REST tanto en cliente como en servidor.

Pautas de elaboración
Requerimiento 1

Se pide hacer un servicio REST, dicho servicio gestionará una serie de Libros.

Los libros tendrán un ID, un título, una editorial y una nota. Los libros se encontrarán alojados en el servidor REST. 
Dicho servidor cuando arranque tendrá 5 libros preestablecidos con todos los datos rellenos. Los libros se guardarán en 
memoria en cualquier tipo de estructura de datos (como puede ser una lista).

El servicio REST proporcionará un servicio CRUD completo, y podrá ser consumido mediante un cliente como Postman y todo el intercambio de mensajes se hará a través de JSON.

Además, se pide a través de Postman realizar las siguientes tareas y apreciar los resultados:

Dar de alta un libro
Dar de baja un libro por ID
Modificar un libro por ID
Obtener un libro por ID
Listar todos los libros
Es importante entender el funcionamiento del cliente Postman, como puede ser entender las URLs de acceso a los diferentes puntos de acceso de nuestro 
servicio REST, los verbos y métodos HTTP que tenemos emplear para cada una de las peticiones, así como en que parte del mensaje HTTP viaja la información.

Requerimiento 2

Se pide que no pueda haber dos libros con ID o título repetido

Requerimiento 3

Se pide crear una aplicación java que sea capaz de trabajar con el servidor REST. La aplicación mostrara un menú que sea capaz de realizar todas las operaciones del servidor, como puede ser:

Dar de alta un libro
Dar de baja un libro por ID
Modificar un libro por ID
Obtener un libro por ID
Listar todos los libros
Salir
Para cada opción, se tendrá que pedir los datos necesarios al usuario y/o mostrar los resultados pertinentes. La aplicación se ejecutará hasta que se pulse la opción de “salir”.

 

Consideraciones
Para toda la actividad se valorará la claridad de código, la modularidad, la eficiencia de los algoritmos empleados 
y comentarios explicativos sobre los puntos clave de la aplicación (JavaDoc o normales, lo que se consideré más apropiado).

Se recomienda el uso de GITHUB para realizar el trabajo de grupo. Se debe aclarar el trabajo aportado por cada alumno en la 
actividad y la metodología seguida. En caso de aportar varias soluciones de diferentes autores, se debe elegir por consenso cual será la solución final escogida.

Para la entrega, se subirá el código fuente comprimido a la plataforma, incluyendo un documento PDF con todo lo necesario 
para demostrar el correcto funcionamiento de la actividad (resultados, capturas de pantalla, ficheros, fotos, etc.). No es 
necesario que el documento PDF sea muy extenso, pero SÍ que incluya, al menos, las capturas de los resultados obtenidos y la explicación 
de los puntos clave de la actividad realizada. También puede ser valido para la entrega subir el PDF con la URL de acceso al repositorio GITHUB sin necesidad de incluir el código fuente.
