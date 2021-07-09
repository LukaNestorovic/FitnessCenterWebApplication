$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let salaId = urlParams.get('salaId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale/" + salaId,
        dataType: "json",
        success: function (res) {
            $('#kapacitet').val(res.kapacitet);
            $('#oznaka_sale').val(res.oznaka_sale);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajSaluForm", function (event) {
        event.preventDefault();
        let kapacitet = $("#kapacitet").val();
        let oznaka_sale = $("#oznaka_sale").val();

        let newSala = {
            kapacitet,
            oznaka_sale
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/sale/" + salaId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newSala),
            success: function (res) {
                alert("Sala " + res.id + " je uspešno ispravljen!");
                window.location.href = "FitnesCentri.html";
            },
            error: function () {
                alert("Greška prilikom ispravke sale!");
            }
        });
    });
});