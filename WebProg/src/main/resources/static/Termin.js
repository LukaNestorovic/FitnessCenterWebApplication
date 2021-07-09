$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');
    $('#dodaj').attr('href', 'NoviTermin.html?treningId=' + treningId);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/za-trening/" + treningId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnIzmeni' data-id=" + res[i].id + ">Izmeni</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let treningId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/termini/za-trening/" + treningId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja termina!");
        }
    });
});

$(document).on('click', '.btnIzmeni', function () {
    let terminId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('treningId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let treningId = urlParams1.get('treningId');
    window.location.href = "UpdateTermina.html?terminId=" + terminId + "?trenerId=" + trenerId + "&treningId=" + treningId;
});