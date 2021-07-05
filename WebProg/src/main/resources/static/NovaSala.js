$(document).on("submit", "#dodajSaluForm", function (event) {
    event.preventDefault();
    let urlParams = new URLSearchParams(window.location.search);
    let salaId = urlParams.get('salaId');
    let kapacitet = $("#kapacitet").val();
    let oznaka_sale = $("#oznaka").val();
    let newSala = {
        kapacitet,
        oznaka_sale
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/za-fitnes/" + salaId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (res) {
            alert("Sala " + res.id + " je uspešno kreiran!");
            window.location.href = "FitnesCentri.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja sale!");
        }
    });
});