/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//User Api
function updateUser(endpoint) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "symptom": document.getElementById("symptom").value,
            "conclusion": document.getElementById("conclusion").value,
            "medicalRegisterId": medicalRegisterMC.value,
            "regulationId": regulationMC.value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteUser(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status === 405) {
            alert("Bạn không đủ quyền để xóa user này!!!");
            l.style.display = "none";
            btn.style.display = "block";
        } else {
            if (res.status !== 204) {
                alert("Wrong!!");
                l.style.display = "none";
                btn.style.display = "block";
            } else {
                alert("Xóa thành công!!!");
                l.style.display = "none";
                r.style.display = "none";
            }
        }
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getUsers(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myUser");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].lastName}</td>
                    <td>${data[i].firstName}</td>
                    <td>${data[i].phoneNumber}</td>
                    <td class=userBirthday>${moment(data[i].dateOfBirth).format('L')}</td>
                    <td>${data[i].sex}</td>
                    <td>${data[i].identifier}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].username}</td>
                    <td>${data[i].password}</td>
                    <td>${data[i].active ? "Còn hạn" : "Hết hạn"}</td>
                    <td class=userDateCreated>${moment(data[i].createdDate).format('L, LTS')}</td>
                    <td>${data[i].avatar}</td>
                    <td>${data[i].userRoleId.id}</td>
                    <td>
                        <div class="spinner-border" style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteUser('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/users/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//Medical Certificate Api
function updateMedicalCertificate(endpoint) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "symptom": document.getElementById("symptom").value,
            "conclusion": document.getElementById("conclusion").value,
            "medicalRegisterId": medicalRegisterMC.value,
            "regulationId": regulationMC.value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteMedicalCertificate(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getMedicalCertificates(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicalCertificate");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td class="mcDateOfExamination">${moment(data[i].dateOfExamination).format('L, LTS')}</td>
                    <td>${data[i].symptom}</td>
                    <td>${data[i].conclusion}</td>
                    <td>${data[i].medicalRegisterId.id}</td>
                    <td>${data[i].regulationId.id}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteMedicalCertificate('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/medical-certificates/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//Disease Api
function updateDisease(endpoint) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "diseaseName": document.getElementById("diseaseName").value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteDisease(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getDiseases(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myDisease");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].diseaseName}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteDisease('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/diseases/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//Regulation Api
function updatePathRegulation(endpoint) {
    let patientQuantity = document.getElementById('patientQuantity').value;
    let examinationPrice = document.getElementById('examinationPrice').value;
    function valueActive()
    {
        var checkbox = document.getElementsByName("active-regulation");
        for (var i = 0; i < checkbox.length; i++) {
            if (checkbox[i].checked === true) {
                return checkbox[i].value;
            }
        }
    }
    ;
    let active = valueActive();

    event.preventDefault();
    fetch(endpoint, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "patientQuantity": patientQuantity,
            "examinationPrice": examinationPrice,
            "active": active
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteRegulation(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getRegulations(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myRegulation");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].patientQuantity}</td>
                    <td>${data[i].examinationPrice}</td>
                    <td>${data[i].active ? "Còn hạn" : "Hết hạn"}</td>
                    <td class="regulationDate">${moment(data[i].createdDate).format('L, LTS')}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteRegulation('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/regulations/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//PrescriptionDetail Api
function updatePrescriptionDetail(endpoint) {
    let prescriptionId = prescriptionIdPrescriptionDetail.value;
    let medicineId = medicineIdPrescriptionDetail.value;

    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "prescriptionId": prescriptionId,
            "medicineId": medicineId,
            "medicineQuantity": document.getElementById('medicineQuantityPrescriptionDetail').value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deletePrescriptionDetail(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function addPrescriptionDetail(endpoint) {
    let prescriptionId = prescriptionIdPrescriptionDetail.value;
    let medicineId = medicineIdPrescriptionDetail.value;

    event.preventDefault();
    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "prescriptionId": prescriptionId,
            "medicineId": medicineId,
            "medicineQuantity": document.getElementById('medicineQuantityPrescriptionDetail').value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("Thêm thành công!");
            location.reload();
        } else {
            console.log("Thêm thất bại!");
            alert("Thêm thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function getPrescriptionDetails(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myPrescriptionDetail");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].prescriptionId.id}</td>
                    <td>${data[i].medicineId.id}</td>
                    <td>${data[i].medicineQuantity}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deletePrescriptionDetail('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/prescription-detail/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//Prescription Api
function updatePatchPrescription(endpoint) {
    let userId = userPrescription.value;
    let medicalCertificateId = medicalCertificatePrescription.value;

    event.preventDefault();
    fetch(endpoint, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "userId": userId,
            "medicalCertificateId": medicalCertificateId
        })
    }).then(function (res) {
        if (res.ok) {
            alert("update thành công!");
            location.reload();
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function addPrescription(endpoint) {
    let userId = userPrescription.value;
    let medicalCertificateId = medicalCertificatePrescription.value;

    event.preventDefault();
    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "userId": userId,
            "medicalCertificateId": medicalCertificateId
        })
    }).then(function (res) {
        if (res.ok) {
            alert("Thêm thành công!");
            location.reload();
        } else {
            console.log("Thêm thất bại!");
            alert("Thêm thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deletePrescription(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getPrescriptions(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myPrescription");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].userId.id}-${data[i].userId.username}</td>
                    <td>${data[i].medicalCertificateId.id}</td>
                    <td class="prescriptionDate">${moment(data[i].createdDate).format('L, LTS')}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deletePrescription('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/prescriptions/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}


//Unit Api
function addUnit(endpoint) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "unitName": document.getElementById('name-unit').value
        })
    }).then(function (res) {
        if (res.ok) {
            alert("Thêm thành công!");
            location.reload();
        } else {
            console.log("Thêm thất bại!");
            alert("Thêm thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function updateUnit(endpoint, unitName) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "unitName": document.getElementById('name-unit').value
        })
    }).then(function (res) {
        if (res.ok) {
            console.log("Update thành công!");
            alert("Update thành công!");
        } else {
            console.log("Update thất bại!");
            alert("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteUnit(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getUnits(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myUnit");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].unitName}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteUnit('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/units/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}

//Medicine Api
function updateMedicine(endpoint) {
    let medicineName = document.getElementById('name-medicine').value;
    let howToUse = document.getElementById('howtouse-medicine').value;
    let medicinePrice = document.getElementById('price-medicine').value;
    let medicineQuantity = document.getElementById('qunatity-medicine').value;
    let unitId = unitMedicine.value;
    function valueActive()
    {
        var checkbox = document.getElementsByName("active-medicine");
        for (var i = 0; i < checkbox.length; i++) {
            if (checkbox[i].checked === true) {
                return checkbox[i].value;
            }
        }
    }
    ;
    let active = valueActive();
    event.preventDefault();
    fetch(endpoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "medicineName": medicineName,
            "howToUse": howToUse,
            "medicinePrice": medicinePrice,
            "medicineQuantity": medicineQuantity,
            "active": active,
            "unitId": unitId
        })
    }).then(function (res) {
        if (res.ok) {
            console.log("Update thành công!");
        } else {
            console.log("Update thất bại!");
        }
        return res;
    }).then(
            res => res.json()
    ).then(
            data => console.log(data)
    ).catch(error => console.log(error))
}

function deleteMedicine(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let l = document.getElementById(`load${id}`);
    l.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Wrong!!!");
        l.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        l.style.display = "none";
    })
}

function getMedicines(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicine");
        let d2 = document.getElementById("mySpinner");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++) {
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].medicineName}</td>
                    <td>${data[i].howToUse}</td>
                    <td>${data[i].medicinePrice}</td>
                    <td>${data[i].medicineQuantity}</td>
                    <td>${data[i].unitId.unitName}</td>
                    <td>${data[i].active ? "Còn hạn" : "Hết hạn"}</td>
                    <td>
                        <div class="spinner-border"style="display:none;" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteMedicine('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                        <a href="/ClinicManagement/admin/medicines/${data[i].id}">
                            <button class="btn btn-info">Sửa</button>
                        </a>
                    </td>
                </tr>`
                d.innerHTML = h;
            }
        }
        d2.style.display = 'none';
    }).catch(function (err) {
        console.error(err);
    })
}
