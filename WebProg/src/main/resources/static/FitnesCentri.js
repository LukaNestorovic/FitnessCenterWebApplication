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