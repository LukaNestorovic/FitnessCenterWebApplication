$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let salaId = urlParams.get('salaId');
    $("#dodaj").attr('href', 'NovaSala.html?salaId=' + salaId);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale/za-fitnes/" + salaId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].kapacitet + "</td>";
                row += "<th>" + res[i].oznaka_sale + "</th>";
                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#sale').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let salaId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/sale/za-fitnes/" + salaId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + salaId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});