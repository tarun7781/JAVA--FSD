//primitives
const expensesAmount = document.getElementById("expensesAmount");
const budgetAmount = document.getElementById("budgetAmount");
const balanceAmount = document.getElementById("balanceAmount");
var currentBudget = document.getElementById("budget").value;

let techStaff = 0;
let nonTechStaff = 0;
let equipments = 0;
let other = 0;
let budget = 0;
let totalBudget = 0;

//functions
function calculateBudget() {
  let totalExp = 0;
  totalExp = data(add);//IIFEs
  currentBudget = document.getElementById("budget").value;
  expensesAmount.innerText = totalExp;
  budgetAmount.innerText = currentBudget;

  balanceAmount.innerText =
    parseInt(budgetAmount.innerText) - parseInt(expensesAmount.innerText);
  result();

  let tabletech = document.getElementById("table-tech");
  tabletech.innerText = parseInt(techStaff);
  let tablenontech = document.getElementById("table-nontech");
  tablenontech.innerText = parseInt(nonTechStaff);
  let tableequipment = document.getElementById("table-equipment");
  tableequipment.innerText = parseInt(equipments);
  let tableother = document.getElementById("table-other");
  tableother.innerText = parseInt(other);

  let showtable = document.getElementById("table-value");
  showtable.style.display = "block";
  //google chart
  google.charts.load("current", { packages: ["corechart"] });
  google.charts.setOnLoadCallback(drawChart);
}
//asyn await
async function result() {
  try {
    const result = await overBudget();
    if (result) {
      let overBudgetResult = document.getElementById("overBudget");
      overBudgetResult.style.display = "block";
    }
  } catch (err) {
    console.log("err", err);
    let underBudget = document.getElementById("underBudget");
    underBudget.style.display = "block";
  }
}
//promise
function overBudget() {
  return new Promise((resolve, reject) => {
    var val = 0;
    if (parseInt(totalBudget) > parseInt(currentBudget)) {
      val = 1;
    }
    val ? resolve("Over budget") : reject("no issues");
  });
}

var add = (techStaff, nonTechStaff, equipments, other) => {
  totalBudget = techStaff + nonTechStaff + equipments + other;
  return totalBudget;
};

var data = (func) => {
  techStaff = document.getElementById("techStaff").value;
  nonTechStaff = document.getElementById("nonTechStaff").value;
  equipments = document.getElementById("equipments").value;
  other = document.getElementById("other").value;
  budget = document.getElementById("budget").value;
  return func(
    parseInt(techStaff),
    parseInt(nonTechStaff),
    parseInt(equipments),
    parseInt(other)
  );
};
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ["Estimates", "Percent"],
    ["Total Budget", parseInt(totalBudget)],
    ["Expences", parseInt(budget)],
  ]);
 //object
  var options = { title: "Total Budget and Expence", width: 600, height: 400 };

  var chart = new google.visualization.PieChart(
    document.getElementById("piechart")
  );
  chart.draw(data, options);
}