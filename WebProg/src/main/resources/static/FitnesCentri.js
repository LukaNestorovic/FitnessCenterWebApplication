$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnescentri",
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].adresa + "</td>";
                row += "<td>" + res[i].email + "</td>";
                row += "<td>" + res[i].broj_telefona + "</td>";
                let btn = "<button class='btnSala' data-id=" + res[i].id + ">Sale</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnDelete' data-id=" + res[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnIzmeni' data-id=" + res[i].id + ">Izmeni</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#fitnesCentri').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on("submit", "#dodajFitnesCentarForm", function (event) {
    event.preventDefault();
    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let email = $("#email").val();
    let broj_telefona = $("#broj_telefona").val();

    let newFitnesCentar = {
        naziv,
        adresa,
        email,
        broj_telefona
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fitnescentri",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (res) {
            alert("Fitnes centar " + res.id + " je uspešno kreiran!");
            window.location.href = "FitnesCentri.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja trenera!");
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let fitnesCentarId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnescentri/" + fitnesCentarId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitnesCentarId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});

$(document).on('click', '.btnSala', function () {
    let salaId = this.dataset.id;
    window.location.href = "Sala.html?salaId=" + salaId;
});

$(document).on('click', '.btnIzmeni', function () {
    let fitnesId = this.dataset.id;
    window.location.href = "UpdateFitnesCentra.html?fitnesId=" + fitnesId;
});