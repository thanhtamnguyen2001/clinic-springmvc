/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function registerChart(id, labels=[], info=[]) {
        let colors = [];
        for (let i = 0; i < info.length; i++) {
                colors.push(Math.floor(Math.random()*16777215).toString(16));
        }
        
        const data = {
                labels: labels,
                datasets: [{
                                label: "Thong ke benh nhan den kham",
                                data: info,
                                backgroundColor: colors,
                                borderColor: colors,
                                hoverOffset: 4
                }]
        };
        
        const config = {
                type: 'line',
                data: data
        };
        
        let ctx = document.getElementById(id).getContext("2d");
        
        new Chart(ctx, config);
}