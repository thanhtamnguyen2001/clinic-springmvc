/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function createCertificate(endpoint, doctorEndpoint, currentUser) {
        let symptom = document.forms["certificate"]["symptom"].value;
        let conclusion = document.forms["certificate"]["conclusion"].value;
        let formCertificate = document.getElementById('certificate');
        let submitCertificate = document.getElementById('submitCertificate');
        let patientRegister = document.getElementById('patientRegister');
        let showCertificate = document.getElementById('showCertificate');

        fetch(endpoint, {
                method: 'POST',
                headers: {
                        'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                        "symptom": symptom,
                        "conclusion": conclusion
                })
        }).then(function (res) {
                return res.json();
        }).then(function (certificate) {
                submitCertificate.style.display = 'none';
                formCertificate.style.display = 'none';
                showCertificate.innerHTML = `<h1 class="text-danger">Phieu kham</h1>
                        <div class="container mt-3">   
                                <table class="table table-striped">
                                        <thead>
                                                <tr>
                                                        <th>ID</th>
                                                        <th>TRIEU CHUNG</th>
                                                        <th>KET LUAN</th>
                                                        <th>NGAY TAO</th>
                                                </tr>
                                        </thead>
                                        <tbody>
                                                <tr>
                                                        <td>${certificate.id}</td>
                                                        <td>${certificate.symptom}</td>
                                                        <td>${certificate.conclusion}</td>
                                                        <td>${moment(certificate.dateOfExamination).format('L, LTS')}</td>
                                                </tr>

                                        </tbody>
                                </table>
                                <button id="createPrescriptionEle" class="btn btn-info" onclick="createPrescription('${doctorEndpoint}', ${certificate.id}, '${currentUser}')">Tạo toa thuốc</button>
                                <button  class="btn btn-success" onclick="findMedicalHistory('${doctorEndpoint}', ${certificate.id}, '${currentUser}')">Xem lịch su khám bệnh</button>
                        </div>
`
        });

}

let countPrescription = 0;
function createPrescription(doctorEndpoint, certificateID, currentUser) {
        const createPrescriptionEndpoint = doctorEndpoint + '/create-prescription/' + (certificateID).toString();
        const getMedicineEndpoint = doctorEndpoint + '/get-medicines';
        let prescriptionEle = document.getElementById('prescription');
        let medicineForm = document.getElementById('medicineForm');
        let createPrescriptionEle = document.getElementById('createPrescriptionEle');


        fetch(createPrescriptionEndpoint, {
                method: 'POST',
                headers: {
                        'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                        "username": currentUser
                })
        }).then(function (res) {
                return res.json();
        }).then(function (prescription) {
                console.log('prescription', prescription)
                const toathuocElement = document.createElement("div");
                toathuocElement.innerHTML = `
                        <div>
                                <h2 class="text-danger">Toa thuốc ${++countPrescription}</h2>
                                <table class="table table-striped">
                                        <thead>
                                                <tr>
                                                        <th>MÃ TOA THUỐC</th>
                                                        <th>BÁC SĨ  </th>
                                                        <th>MÃ PHIẾU KHÁM</th>
                                                        <th>NGÀY TẠO </th>                                      
                                                </tr>
                                        </thead>
                                        <tbody>
                                                <tr>
                                                        <td>${prescription.id}</td>
                                                        <td>${currentUser}</td>
                                                        <td>${certificateID}</td>
                                                        <td>${moment(prescription.createdDate).format('L, LTS')}</td>
                                                </tr>

                                        </tbody>                                     
                                </table>
                        </div>
                        <div>       
                                <table class="table">
                                        <thead>
                                                <tr>
                                                        <th>Mã thuốc</th>
                                                        <th>Tên thuốc</th>
                                                        <th>Số luong</th>
                                                </tr>
                                        </thead>
                                        <tbody id="medicineInPrescription-${prescription.id}">

                                        </tbody>
                                </table>
                        </div>
`
                createPrescriptionEle.innerHTML = 'Tiếp tục tạo toa thuốc';
                prescriptionEle.appendChild(toathuocElement);
                medicineForm.innerHTML = `
                        <br> <br><br>
                        <div class="d-flex">
                                <input id="inputSearchMedicine" class="form-control me-2" type="text" placeholder="Nhập tên thuốc..." onchange="findMedicine('${doctorEndpoint}', ${prescription.id})">
                         </div>
                        <div class="mb-3 mt-3">
                                <label for="medicineName" class="form-label"></label>
                                <select id="medicine" class="form-select" size="3" aria-label="size 3 select example" style="min-height: 400px">
                                </select>
                        </div>
                        
`

                let medicineElement = document.getElementById('medicine');

                fetch(getMedicineEndpoint)
                        .then(function (res) {
                                return res.json();
                        }).then(function (medicines) {
                        let len = medicines.length;
                        let htmlMedicines = '';
                        for (let i = 0; i < len; i++) {

                                htmlMedicines += `<option onclick="addMedicine('${doctorEndpoint}', ${prescription.id}, ${medicines[i].id})"
                                value="${medicines[i].id}">${medicines[i].medicineName}</option> `
                        }

                        medicineElement.innerHTML = htmlMedicines;
                });
        });

}
let medicineList = [];
let medicineObjects = [];


function addMedicine(doctorEndpoint, prescriptionID, medicineID) {
        const endpoint = doctorEndpoint + '/add-medicine/' + prescriptionID;

        const medicineInPrescriptionEle = document.getElementById(`medicineInPrescription-${prescriptionID}`);


        if (!medicineList.includes(medicineID)) {
                medicineList.push(medicineID);

                fetch(endpoint, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                                "medicineId": medicineID,
                                "quantity": 1
                        })
                }).then(function (res) {
                        return res.json();
                }).then(function (preMedicine) {
                        medicineObjects.push({"id": preMedicine.id, "medicineID": medicineID});
                        const medicineNode = document.createElement("tr");
                        medicineNode.innerHTML = ` 
                                        <tr class ="medicine">
                                                <td>${preMedicine.medicineId.id}</td>
                                                <td>${preMedicine.medicineId.medicineName}</td>
                                                 <td><input onchange="setQuantity(event,'${doctorEndpoint}', '${preMedicine.id}')" class="form-control me-2" type="number" id="quantity-${preMedicine.id}" name="quantity" value="${preMedicine.medicineQuantity}" style="max-width:200px;"></td>
                                                
                                        </tr>                      
                `
                        medicineInPrescriptionEle.appendChild(medicineNode);
                });
        } else {
                let index = medicineList.indexOf(medicineID);
                let prescriptionDetailID = medicineObjects[index].id;

                const endpointAlterMedicine = doctorEndpoint + '/alter-medicine/' + prescriptionDetailID;

                fetch(endpointAlterMedicine, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                        }) //phai co cai nay du k co data
                }).then(function (res) {
                        return res.json();
                }).then(function (preMedicine) {
                        let idQuantity = 'quantity-' + preMedicine.id;
                        let quantityElement = document.getElementById(idQuantity);
                        quantityElement.value = preMedicine.medicineQuantity + 1;
                });

        }
}

function setQuantity(event, doctorEndpoint, prescriptionDetailID) {
        const endpointAlterMedicine = doctorEndpoint + '/alter-medicine/' + prescriptionDetailID;
        let quantity = event.target.value;
        fetch(endpointAlterMedicine, {
                method: 'POST',
                headers: {
                        'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                        "quantity": quantity
                })
        })
}

function findMedicine(doctorEndpoint, prescriptionID) {
        let inputSearchMedicine = document.getElementById("inputSearchMedicine");
        const getMedicineEndpoint = doctorEndpoint + '/get-medicines/?name=' + inputSearchMedicine.value;

        let medicineElement = document.getElementById('medicine');

        fetch(getMedicineEndpoint)
                .then(function (res) {
                        return res.json();
                }).then(function (medicines) {
                let len = medicines.length;
                let htmlMedicines = '';
                for (let i = 0; i < len; i++) {

                        htmlMedicines += `<option onclick="addMedicine('${doctorEndpoint}', ${prescriptionID}, ${medicines[i].id})"
                                value="${medicines[i].id}">${medicines[i].medicineName}</option> `
                }

                medicineElement.innerHTML = htmlMedicines;
        });
}



function findMedicalHistory(doctorEndpoint) {

        let getCertificateEndpoint;
        let medicalHistoryElement = document.getElementById('medicalHistory');
        let hideAndPresentlyElement = document.getElementById('hideAndPresently');

        let myPromise = new Promise(function (myResolve, myReject) {
                medicalHistoryElement.innerHTML = `<br><input id="phoneRegister" type="text" class="form-control" placeholder="Nhập sdt bệnh nhân..."><br>`

                const phoneRegisterElement = document.getElementById('phoneRegister');

                phoneRegisterElement.onchange = function () {
                        myResolve(phoneRegisterElement.value);
                };
        });

        myPromise.then(function (inputValue) {
                getCertificateEndpoint = doctorEndpoint + "/get-certificates/?phone=" + inputValue;

                fetch(getCertificateEndpoint)
                        .then(function (res) {
                                return res.json();
                        }).then(function (certificates) {

                        const findAgainBtn = document.createElement("div");
                        findAgainBtn.innerHTML = `<br><br><button onclick="findMedicalHistory('${doctorEndpoint}')" class="btn btn-primary">Tiếp tục tìm</button><br><br>`
                        medicalHistoryElement.appendChild(findAgainBtn);

                        if (certificates.length == 0) {
                                let certificateNode = document.createElement("div");
                                certificateNode.setAttribute("id", "certificateHistory");
                                certificateNode.innerHTML = `<h1 class="text-danger">Bệnh nhân không tồn tại trong hệ thống</h1>`
                                medicalHistoryElement.appendChild(certificateNode);
                        } else {
                                certificates.forEach(certificate => {

                                        let certificateNode = document.createElement("div");
                                        certificateNode.setAttribute("id", "certificateHistory");
                                        certificateNode.innerHTML = `
                                        <div class="container mt-3">   
                                                <table class="table table-striped">
                                                        <thead>
                                                                <tr>
                                                                        <th>MÃ PHI?U KHÁM</th>
                                                                        <th>TÊN B?NH NHÂN</th>
                                                                        <th>NGÀY KHÁM</th>
                                                                        <th>TRIỆU CHỨNG</th>
                                                                        <th>KẾT LUẬN</th>
                                                                </tr>
                                                        </thead>
                                                        <tbody>
                                                                <tr>
                                                                        <td>${certificate[0].id}</td>
                                                                        <td>${certificate[1].patientName}</td>
                                                                        <td>${certificate[0].dateOfExamination}</td>
                                                                        <td>${certificate[0].symptom}</td>
                                                                        <td>${certificate[0].conclusion}</td>
                                                                </tr>

                                                        </tbody>
                                                </table>
                                        </div>
`
                                        medicalHistoryElement.appendChild(certificateNode);
                                });
                                let hideCertificateNode = document.createElement("div");
                                hideAndPresentlyElement.innerHTML = `<br><button id="hideAndPresentlyBtn" class="btn btn-primary" onclick="hideMedicalHistory()">Ẩn danh sách khám </button><br><br>`
                                medicalHistoryElement.appendChild(hideCertificateNode);
                        }


                });
        });

}
let countHidePre = 0;
function hideMedicalHistory() {

        let medicalHistory = document.getElementById('medicalHistory');
        let hideAndPresentlyBtn = document.getElementById('hideAndPresentlyBtn');

        if (countHidePre % 2 === 0) {
                medicalHistory.style.display = "none";
                hideAndPresentlyBtn.innerHTML = "Hiên danh sách khám";
                countHidePre++;
        } else {
                medicalHistory.style.display = "block";
                hideAndPresentlyBtn.innerHTML = "Ẩn danh sách khám";
                countHidePre++;
        }
}







//function getCertificate(endpoint) {
//        let certificate = document.getElementById('getCertificate');
//        fetch(endpoint)
//                .then(function (res) {
//                        return res.json();
//                }).then(function (data) {
//                certificate.innerHTML = `<h1 class="text-danger">Phieu kham</h1>
//<div class="container mt-3">   
//        <table class="table table-striped">
//                <thead>
//                        <tr>
//                                <th>ID</th>
//                                <th>TRIEU CHUNG</th>
//                                <th>KET LUAN</th>
//                                <th>NGAY TAO</th>
//                        </tr>
//                </thead>
//                <tbody>
//                        <tr>
//                                <td>${data.id}</td>
//                                <td>${data.symptom}</td>
//                                <td>${data.conclusion}</td>
//                                <td>${data.dateOfExamination}</td>
//                        </tr>
//
//                </tbody>
//        </table>
//                
//</div>
//`
//        });
//}
