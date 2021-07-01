$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/za-trening/" + treningId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});