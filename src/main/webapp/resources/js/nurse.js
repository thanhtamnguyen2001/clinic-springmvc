/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function confirmMedicalRegister(endpoint, isVerifie, id) {

//        let verifiedBtn = document.getElementById();
//        console.log(verifiedBtn);

        fetch(endpoint, {
                method: "post",
                headers: {
                        'Content-Type': 'application/json'
                }
        }).then(function () {
                location.reload();
        });



//        .then(function (res) {
//                return res.json();
//        }).then(function (data) {
//                if (data) {
//                        if (isVerified === 'true') {
//                                <button type="button" class="btn btn-danger">Unverified</button>
//                        }
//                }
//        });
}

