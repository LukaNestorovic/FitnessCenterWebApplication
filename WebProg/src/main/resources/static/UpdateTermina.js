$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let terminId = urlParams.get('terminId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/" + terminId,
        dataType: "json",
        success: function (res) {
            $('#cena').val(res.cena);
            $('#datum_vreme').val(res.datum_vreme);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajTerminForm", function (event) {
        event.preventDefault();
        let urlParams1 = new URLSearchParams(window.location.search);
        let trenerId = urlParams1.get('trenerId');
        let cena = $("#cena").val();
        let datum_vreme = $("#datum_vreme").val();

        let newTermin = {
            cena,
            datum_vreme
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/termini/" + terminId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
            success: function (res) {
                alert("Termin " + res.id + " je uspešno ispravljen!");
                window.location.href = "Treninzi.html?trenerId=" + trenerId;
            },
            error: function () {
                alert("Greška prilikom ispravke termina!");
            }
        });
    });
});