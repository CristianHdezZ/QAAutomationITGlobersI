Feature: Consultar en Fravega
  Como Usuario
  Quiero ingresar a la home de Frávega
  A consulta informacion de productos

  @ConsultaExitosaFravega
  Scenario Outline: Consulta de Heladeras
    Given Cristian ingresa a la home de Frávega
    When busca la palabra
      |<palabra>|
    And Filtra desde los filtros de la sección izquierda de la página por
      |<filtroPalabra>|
    And Filtra en sección izquierda de la página por la marca
      |<marca>|
    Then cada uno de los elementos contenga en su title la marca filtrada
      |<marca>|
    And la cantidad de elementos de la lista coincida con los resultados mostrandos por el frontend
    And en el breadcrumb de la página se encuentre la palabra
      |<filtroPalabra>|
    Examples:
    |palabra|filtroPalabra|marca|
    |Heladera|Heladeras   |patrick|
