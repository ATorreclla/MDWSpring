# Proyecto con Metodologías Ligeras MDW
#### Máster en Ingeniería Web por la U.P.M.
#### Descripción de la práctica:
Una empresa hotelera desea revolucionar el alquiler de   
habitaciones de hotel mediante la oferta de habitaciones   
por horas. Para ello, desea realizar una aplicación web   
para la gestión de la disponibilidad y de las reservas   
online de las habitaciones. Para alcanzar este objetivo, 
ha encomendado a los profesores de Metodologías de Desarrollo Web   
verificar el avance del proyecto e interactuar con los equipos   
de desarrollo de la ETSISI.

La aplicación deseada permitirá a la empresa dar de alta   
diversas cadenas de hoteles. De cada cadena de hoteles,   
además de su responsable, se debe conocer el nombre de la misma   
y el logotipo. Cada cadena de hotel tendrá un responsable de cadena,   
que podrá administrar los hoteles pertenecientes a dicha cadena   
(darlos de alta, baja y modificarlos). Una cadena podrá tener uno   
o más hoteles que admitan reservas por horas.

De cada hotel, se debe recoger el nombre del hotel, la dirección postal,   
el nombre y apellidos del director del hotel y una imagen representativa.   
Cada hotel tendrá un responsable de hotel, que será el encargado   
de gestionar las habitaciones de dicho hotel. El responsable de   
hotel será el encargado de dar de alta las habitaciones disponibles,   
en la modalidad de alquiler por horas. Para cada habitación,   
el sistema debe permitir establecer la disponibilidad de la misma por fecha y horario.   
El horario podrá variar según el día. El gestor de cada hotel,   
además de poder dar de alta habitaciones, debe poder eliminar y modificar   
los datos de las habitaciones bajo su supervisión.

De cada habitación, se desea conocer el tipo de habitación:   
individual, doble, triple o suite. Además, se deben conocer los servicios   
adicionales de los que dispone la habitación: televisión, Internet,   
aire acondicionado, minibar, jacuzzi, etc. Para cada habitación,   
se establecerá además el precio por hora de la misma. 
Los clientes, deben poder buscar, a través de Internet, habitaciones por   
diferentes criterios: ubicación, nombre de hotel, fecha y franja horaria.   
Una vez localizado un hotel que disponga de habitaciones que encajen en sus   
características deseadas, el sistema debe permitir al cliente realizar una   
reserva de la habitación indicando el número de horas que desea utilizar la misma.

Al realizar la reserva, si el cliente ya tiene cuenta en la aplicación,   
el sistema dejará al cliente hacer login. En caso contrario, el sistema debe recoger   
los datos básicos del cliente, incluido su correo electrónico, con el que se   
creará una cuenta automáticamente para el cliente, quien podrá solicitar   
al sistema “recordar su contraseña”. Una vez que el cliente esté registrado en el sistema,   
se recogerán los datos relativos a la reserva, se calculará el precio de   
la misma (precio de la habitación por hora multiplicado por el número de horas reservadas)   
y se conducirá al cliente a una pasarela de pago por tarjeta de débito/crédito.

Los clientes deben poder acceder al sistema y modificar tanto sus datos personales   
como los datos relativos a sus reservas (cancelación o modificación de la misma).   
El sistema no almacenará datos de tarjetas bancarias.

Cuando se realice la compra, el cliente recibirá una confirmación por pantalla,   
así como un correo electrónico de confirmación con un código de reserva.   
Adicionalmente, el responsable del hotel recibirá un correo indicando que se ha   
realizado una nueva reserva y los datos de la misma. La habitación debe quedar   
bloqueada durante esas horas de manera automática. Así mismo, será necesario   
dejar un margen adicional de dos horas después de que quede libre para poder   
limpiarla y prepararla para otra reserva.

El gestor del hotel debe poder visualizar las reservas sobre todas sus habitaciones,   
y tener un mecanismo para cancelar una reserva determinada, por causa de fuerza mayor.   
Si esto sucede, el sistema debe permitir al gestor incluir un mensaje personalizado   
para el cliente, quien recibirá un correo electrónico indicando que la reserva   
se ha cancelado y dándole la opción de, a través de la aplicación, acceder a un bono   
para la realización de otra reserva equivalente, o bien recuperar su dinero.

Cuando el cliente acude al hotel, el personal de recepción del hotel   
(no necesariamente el gestor) le solicita el código de reserva que el cliente recibió   
por correo electrónico. Con este código el personal de recepción puede confirmar   
que el cliente ha acudido al hotel, para posteriormente recibir la liquidación   
correspondiente, que se ha cobrado previamente el sistema.  

##### Integrantes del equipo de desarrollo:  
* Sandra Ortega Sánchez: Product Ownwer.  
* Eric Aldas: Scrum Master.  
* Alberto García Garabal.  
* Ramón Roca Martínez.  
* Agustín Torrecilla Sánchez.  
* Bruno Martín López.  
* Miguel Calderón Sang.  
* Xinyu Li.  




