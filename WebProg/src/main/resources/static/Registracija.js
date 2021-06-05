$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/registracijatrenera",
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].email + "</td>";
                row += "<td>" + res[i].lozinka + "</td>";
                row += "<td>" + res[i].korisnicko_ime + "</td>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].kontakt_telefon + "</td>";
                row += "<td>" + res[i].datum_rodjenja + "</td>";
                row += "<td>" + res[i].uloga + "</td>";
                row += "</tr>";

                $('#treneri').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on("submit", "#dodajTreneraForm", function (event) {
    event.preventDefault();
    let email = $("#email").val();
    let lozinka = $("#lozinka").val();
    let korisnicko_ime = $("#korisnicko_ime").val();
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let kontakt_telefon = $("#kontakt_telefon").val();
    let datum_rodjenja = $("#datum_rodjenja").val();
    let uloga = $("#uloga :selected").val();

    let newTrener = {
        email,
        lozinka,
        korisnicko_ime,
        ime,
        prezime,
        kontakt_telefon,
        datum_rodjenja,
        uloga
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/registracijatrenera",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrener),
        success: function (res) {
            alert("Trener " + res.id + " je uspešno kreiran!");
            window.location.href = "Treneri.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja trenera!");
        }
    });
});

 /*   let newEmployee = {
        firstName,
        lastName,
        position: jobPosition     // zbog backend-a jobPosition moramo preimenovati u atribut position
    }

    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/employees",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newEmployee),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
        console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

        alert("Radnik " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
        window.location.href = "employees.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});*/