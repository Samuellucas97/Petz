Feature: Buy Product
  Scenario: Purchase from a search
    Given User accesses the Petz website home page
    When find by "coleira"
    And Press the enter button
    Then Show a list of products related with "coleira"
    When Choose "Guia Petz Flamingo para Cães"
    Then Show for "Tamanho PP" with the price "R$ 39,99"