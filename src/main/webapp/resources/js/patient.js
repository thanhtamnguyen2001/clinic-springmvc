/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getMedicalHistory(endpoint) {
        let medicalHistoryEndpoint = endpoint + "patient/medical-history";
        let medicalHistoryElement = document.getElementById('root');

        fetch(medicalHistoryEndpoint)
                .then(function (res) {
                        return res.json();
                }).then(function (certificatesList) {

                if (certificatesList.length === 0) {
                        let certificateNode = document.createElement("div");
                        certificateNode.setAttribute("id", "certificateHistory");
                        certificateNode.innerHTML = `<br><br><h1 class="text-danger">Bạn không có lịch sử khám</h1>`
                        medicalHistoryElement.appendChild(certificateNode);
                } else {
                        certificatesList.forEach(certificates => {
                                certificates.forEach(certificate => {
                                        let certificateNode = document.createElement("div");
                                        certificateNode.setAttribute("id", "certificateHistory");
                                        certificateNode.innerHTML = `
                                        <div class="container mt-3 " id="certificateNode-${certificate.id}">   
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
                                                                        <td>${certificate.id}</td>
                                                                        <td>${certificate.medicalRegisterId.patientName}</td>
                                                                        <td>${certificate.dateOfExamination}</td>
                                                                        <td>${certificate.symptom}</td>
                                                                        <td>${certificate.conclusion}</td>
                                                                </tr>
                                                        </tbody>
                                                </table>
                                                <button id="certificateBtn-${certificate.id}" class="btn btn-success" onclick="handlePrescription('${endpoint}', ${certificate.id}, 'certificateBtn-${certificate.id}')">Xem toa thuốc</button>
                                         </div>
`
                                        medicalHistoryElement.appendChild(certificateNode);
                                });

                        });
                }
        });
}

function handlePrescription(endpoint, certificateID, idElement) {
        const getPrescriptionEndpoint = endpoint + "get-prescription/" + certificateID;
        let certificateNode = document.getElementById(`certificateNode-${certificateID}`);
        let certificateBtn = document.getElementById(idElement);


        fetch(getPrescriptionEndpoint)
                .then(res => res.json())
                .then(prescriptions => {
                        let count = 1;
                        let prescriptionNode = document.createElement("div");
                        let htmls = '';
                        prescriptions.forEach((prescription, index) => {
                                htmls += `
                                        <th><h5 class="text-danger">Toa thuốc  ${count}</h5></th>
                                        <div  class="container mt-3" >   
                                                <table id="prescription-${prescription.id}" class="table table-striped">
                                                        <thead>
                                                                <tr>
                                                                        <th>Ngày tạo</th>       
                                                                        <th>Bác sĩ ra toa</th>
                                                                </tr>
                                                        </thead>
                                                        <tbody>
                                                                <tr>
                                                                        <td>${prescription.createdDate}</td>
                                                                        <td>${prescription.userId.lastName} ${prescription.userId.firstName}</td>
                                                                </tr>
                                                        </tbody>
                                                </table>
                                                <button id="seeDetail-${index}" class="btn btn-success" onclick="handlePrescriptionDetail('${endpoint}', ${prescription.id}, 'seeDetail-${index}')">Xem chi tiết</button>
                                        </div>
`
                                count++;
                        });
                        prescriptionNode.innerHTML = htmls;
                        certificateNode.appendChild(prescriptionNode);
                        certificateBtn.style.display = "none";
                });
}

function handlePrescriptionDetail(endpoint, prescriptionID, idSeeDetail) {
        const getPrescriptionDetailEnpoint = endpoint + "get-prescriptionDetail/" + prescriptionID;
        const prescriptionNode = document.getElementById(`prescription-${prescriptionID}`);
        const idSeeDetailbtn = document.getElementById(idSeeDetail);

        let medicineTitleNode = document.createElement("div");

        medicineTitleNode.innerHTML = `
                                <table class="table">
                                        <thead>
                                                <tr>
                                                        <th>Mã thuốc</th>
                                                        <th>Tên thuốc</th>
                                                        <th>Giá thuốc</th>
                                                        <th>Cách dùng</th>
                                                        <th>Đơn vị</th>
                                                        <th>Số lượng</th> 
                                                </tr>
                                        </thead>
                                </table>`
        prescriptionNode.appendChild(medicineTitleNode);

        fetch(getPrescriptionDetailEnpoint)
                .then(res => res.json())
                .then(presciptionDetails => {
                        let htmls =
                                presciptionDetails.forEach(pd => {
                                        let medicineNode = document.createElement("div");
                                        medicineNode.setAttribute("class", "medicineNode");
                                        medicineNode.innerHTML = `
                                                <table class="table">
                                                        <tbody class="medicineInPrescription">
                                                                <td>${pd.medicineId.id}</td>
                                                                <td>${pd.medicineId.medicineName}</td>
                                                                <td>${pd.medicineId.medicinePrice}</td>
                                                                <td>${pd.medicineId.howToUse}</td>
                                                                <td>${pd.medicineId.unitId.unitName}</td>
                                                                <td>${pd.medicineQuantity}</td>
                                                        </tbody>
                                                </table>`
                                        medicineTitleNode.appendChild(medicineNode);
                                        medicineTitleNode.setAttribute("class", "medicineTitleNode");

                                });
                                idSeeDetailbtn.style.display = "none";
                });
}
