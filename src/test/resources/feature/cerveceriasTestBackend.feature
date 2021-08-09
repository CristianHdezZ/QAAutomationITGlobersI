Feature: Consulta de cervecerias
  Como Usuario
  Quiero ingresar al API Rest
  A consulta informacion de cervecerias

  @ConsultaExitosaCervecerias
  Scenario Outline: Consulta de cervecerias
    Given Cristian obtiene una lista de cervecerías que contengan en su nombre, el texto
      |<name>|
    When de la lista de resultados toma aquellos que contengan en la key name, el valor
      |<keyName>|
    And por cada elemento de la lista anterior pedir el detalle en API y tomar solo aquel que contenga
      |<state>|
    Then Sobre la cervecería resultante, assertar lo siguiente
      |<keyName>|<street>|<phone>|
    Examples:
      |name|keyName|state|street|phone|
      |lagunitas|Lagunitas Brewing Co|California|1280 N McDowell Blvd|7077694495|