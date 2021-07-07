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

                $('#sviodradjenitreninzi').append(row);

                if(res[i].ocena != null) {
                    let row = "<tr>";
                    row += "<td>" + res[i].ocena + "</td>";
                    row += "<th>" + res[i].naziv + "</th>";
                    row += "<th>" + res[i].tip_treninga + "</th>";
                    row += "<th>" + res[i].datum_vreme + "</th>";
                    row += "</tr>";

                    $('#odradjenitreninzi').append(row);
                }
                else{
                    let row = "<tr>";
                    row += "<td>" + res[i].ocena + "</td>";
                    row += "<th>" + res[i].naziv + "</th>";
                    row += "<th>" + res[i].tip_treninga + "</th>";
                    row += "<th>" + res[i].datum_vreme + "</th>";
                    let btn = "<button class='btnOceni' data-id=" + res[i].id + ">Oceni</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";

                    $('#odradjenitreninzibezocene').append(row);
                }
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});