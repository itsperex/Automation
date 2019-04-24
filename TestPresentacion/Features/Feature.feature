@tag
Feature: Gestion en blazedemo.com

	
	Scenario: SetUp
		Given Cargar driver y configuracion
	
  @tag1
  Scenario: Pantalla de Seleccion de destino
  	
    Given Verificar que estamos en BlazeDemo
    When Seleccione origen
    And Seleccione destino
    Then Pulsamos el boton y pasamos a buscar vuelos

  @tag2
  Scenario: Pantalla de Seleccion de vuelo
    Given Verificar que estamos en la pagina de seleccion de vuelo
    When Seleccionamos un vuelo

  @tag3
  Scenario: Pantalla de informacion personal para la compra del vuelo
    Given Verificar que estamos en la pagina informacion personal
    When Rellenamos nuestros datos personales
    Then Pulsamos el boton para confirmar la compra
    And Cerramos el driver
    
