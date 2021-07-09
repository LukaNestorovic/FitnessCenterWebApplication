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
                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
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

    if(uloga === "Trener") {

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
                window.location.href = "LogIn.html";
            },
            error: function () {
                alert("Greška prilikom dodavanja trenera!");
            }
        });
    } else if (uloga === "Clan") {

        let newClan = {
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
            url: "http://localhost:8080/api/registracijaclana",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newClan),
            success: function (res) {
                alert("Clan " + res.id + " je uspešno kreiran!");
                window.location.href = "LogIn.html";
            },
            error: function () {
                alert("Greška prilikom dodavanja clana!");
            }
        });
    }
});

$(document).on('click', '.btnDelete', function () {
    let treneriId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/registracijatrenera/" + treneriId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + treneriId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});