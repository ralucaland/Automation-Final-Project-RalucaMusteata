# Proiect Final QA Automation_RalucaMusteata
## 1. Descriere proiect

Acest proiect reprezintă un proiect final de QA Automation.

Proiectul conține teste automate pentru interfața aplicației, adică teste UI, și teste automate pentru API.

Scopul proiectului este să demonstreze că pot crea, organiza și rula teste automate folosind Java, Selenium WebDriver, TestNG, Maven și RestAssured.

În proiect am inclus:
- teste UI
- teste API
- scenarii pozitive
- scenarii negative
- structură Page Object Model
- raport de testare Extent Report
- documentarea unui bug întâlnit și a workaround-ului aplicat

## 2. Tehnologii folosite

În acest proiect am folosit următoarele tehnologii și tool-uri:

- Java
- Selenium WebDriver
- TestNG
- Maven
- RestAssured
- Hamcrest Matchers
- Extent Reports
- IntelliJ IDEA
- Git
- GitHub
- 
## 3. Structura proiectului

Proiectul este împărțit în mai multe pachete, pentru a separa clar testele UI, testele API, paginile și datele reutilizabile.

### Teste UI-testat pe Opensource-demo

Testele UI sunt organizate folosind Page Object Model.

Clasele de pagină se află în `src/test/java/pages`.

Clasele de test UI se află în `src/test/java/tests`.

În testele UI au fost verificate scenarii precum login, navigare în aplicație, validare elemente afișate și fluxuri legate de angajați sau leave/concediu.

### Teste API- testat pe Practicesoftwaretesting.com 

Testele API sunt organizate în pachetul `src/test/java/api` și au fost create folosind RestAssured.

Aceste teste verifică scenarii de tip GET și POST pentru produse și login.

Scenariile acoperite sunt: căutare produs existent, căutare produs inexistent, obținere produs după ID valid și login cu date invalide.

Validările principale sunt pentru status code, conținutul răspunsului și mesajul de eroare pentru autentificare invalidă.

### Date și configurări

Proiectul conține clase separate pentru date și configurări reutilizabile.

Aici sunt păstrate valori precum base URL, endpoint-uri, date de login, valori de căutare și ID-uri folosite în teste.

Această abordare face proiectul mai ușor de întreținut și mai clar.