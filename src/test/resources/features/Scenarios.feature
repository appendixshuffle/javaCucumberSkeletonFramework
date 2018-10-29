Feature: Regression scenarios of Kompass Advisory Page


  Background:
    Given I'm logged Agent into Kompass and i want to introduce Cyber produkt to the Client

  @Regress3
  Scenario Outline: testing Cyber Advisory Page - Happy Path with every business type related to the Tierarzt
    When I select "<business type>" in betriebsart section
    Then I can select "<Haftpflicht-Gewerbe>" in "Haftpflicht-Gewerbe" field
    And I can select "<Sach-Gewerbe>" in "Sach-Gewerbe" field
    And I can select "<Vermögensschaden-Haftpflicht>" in "Vermögensschaden-Haftpflicht" field
    And I can select "<Rechtsschutz>" in "Rechtsschutz" field

    When I answer to orientation question of the section:
      | orientation question         | answer         |
      | Jahresumsatz                 | < 100.000      |
      | Mitarbeiter                  | < 35           |
      | Jahreslohnsumme              | 200.000        |
      | Fuhrpark                     | Ja             |
      | Immobilienbesitz Gewerbliche | Nein           |
      | Immobilienbesitz Geplante    | Ja             |
      | Immobilienbesitz Grundstücke | Ja             |
      | Risikoanschrift Street Name  | Überseering 35 |
      | Risikoanschrift Postal Code  | 22297          |
      | Risikoanschrift City         | Hamburg        |
    Then I have green check mark above the every section
    When I want to adjust one of the "<products>"
    Then I need to answer to additional questions from the Advisory Page:
      | advisory question           | advisory answer |
      | Unternehmerische Kennzahlen | < 500000        |
      | Cyber Versicherungssumme    | 50.000 €        |
    And  I have to select "<product option>"
    And I'm abble to chose "<output form>" of my calculation
    Examples:
      | business type | Haftpflicht-Gewerbe                | Sach-Gewerbe   | Vermögensschaden-Haftpflicht | Rechtsschutz             | products | product option             | output form |
      | Tierarzt      | Tierarzt mit Klinik, freiberuflich | Tierarztpraxis | Tierärztlicher Gutachter     | Tierarztpraxis           | Cyber    | Cyber-Versicherung Kompakt | Calc        |
      | Tierarzt      | Tierarzt (Praxis für Großtiere)    | Tierarztpraxis | Tierärztlicher Gutachter     | Tierärztlicher Gutachter | Cyber    | Cyber-Versicherung         | PDF         |
      | Tierarzt      | Tierarzt (Praxis für Kleintiere)   | Tierarztpraxis | Tierärztlicher Gutachter     | Tierärztlicher Gutachter | Cyber    | Cyber-Versicherung Kompakt | Calc        |
      | Tierarzt      | Tierarzt in abhängiger Stellung    | Tierarztpraxis | Tierärztlicher Gutachter     | Tierarztpraxis           | Cyber    | Cyber-Versicherung         | PDF         |