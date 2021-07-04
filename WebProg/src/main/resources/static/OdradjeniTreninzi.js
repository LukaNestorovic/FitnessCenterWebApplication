$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni-treninzi",
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].ocena + "</td>";
                row += "<th>" + res[i].naziv + "</th>";
                row += "<th>" + res[i].tip_treninga + "</th>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});