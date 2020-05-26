# s4ntest

# RESUMEN
Esta aplicación cubre la prueba de leer las instrucciones de archivos.txt que contiene los movimientos que debe hacer el dron,
y genera un archivo txt por cada dron mostrando la ubicación en la que quedó después cada pedido. Por ejemplo:
AAAAIAA
DDDAIAD
AAIADAD
Donde:
● La letra A corresponde a un movimiento hacia adelante.
● La letra I corresponde a un giro de 90 grados del dron a la izquierda.
● La letra D corresponde a un giro de 90 grados del dron a la derecha.

Cada dron empieza en la ubicación 0,0 dirección NORTE, entonces tomando como ejemplo la primera ruta AAAAIAA quedaría de la siguiente forma:
(-2,4) dirección ORIENTE, ya que tenemos 4 movimientos hacía adelante que aumenta el valor en x ya que empieza apuntando al NORTE, hace un giro a la izquierda y su orientación cambia a ORIENTE y avanza dos espacios a la izquierda del eje y por lo tanto queda en -2.

Para la segunda ruta DDDAIAD quedaría de la siguiente forma:
(-1, 3) dirección SUR: arrancando desde la posición y orientación anterior tenemos 3 indicaciones de giro a la derecha, es decir, en el primer giro queda apuntando al NORTE, en el segundo queda apuntando al OCCIDENTE, y en el tercer giro queda apuntando al SUR, allí hace un movimiento hacía adelante, es decir hacía abajo disminuyendo el valor en x quedando en 3, después da un giro a la izquierda donde apunta al occidente y allí avanza en este caso incrementando el valor en y por lo tanto quedaría en -1 y por último hace un giro a la derecha apuntando de nuevo hacía el SUR.

# COSAS POR MEJORAR
● Manejo de excepciones
● Actualmente la ruta donde se leen y se generan los archivos está en una constante la cual tendría que cambiar para cada
laptop, así que una mejora sería hacer esta ruta configurable de un archivo de propiedades o buscar la forma de que acceda
a una ubicación dentro del mismo proyecto sin necesidad de tener que buscar toda la ruta completa
● Si hay varios archivos txt que no tengan las instrucciones para las cuales se programó este proyecto, la aplicación
generará archivos por cada uno que encuentre, se podría agregar validaciones al respecto y también se podría agregar en la parte de 
manejo de excepciones.
● Se agregaron archivos generados por la aplicación como prueba y ejemplo de su funcionamiento
