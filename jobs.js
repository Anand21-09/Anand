async function fetchJobs() {
  let response = await fetch("jobs.json"); // Load the JSON file
  let data = await response.json();
  return data.jobs;
}

async function displayJobs() {
  let jobs = await fetchJobs();
  let jobList = document.getElementById("jobList");
  jobList.innerHTML = "";

  jobs.forEach((job) => {
    let card = document.createElement("div");
    card.className = "job-card";
    card.innerHTML = `
      <h3>${job.role}</h3>
      <p><strong>Company:</strong> ${job.company}</p>
      <p><strong>Location:</strong> ${job.location}</p>
      <p><strong>Salary:</strong> ${job.salary}</p>
      <p>${job.description || ""}</p>
    `;
    jobList.appendChild(card);
  });
}

async function searchJobs() {
  let searchQuery = document
    .getElementById("jobSearchInput")
    .value.toLowerCase();
  let jobs = await fetchJobs();
  let filteredJobs = jobs.filter(
    (job) =>
      job.role.toLowerCase().includes(searchQuery) ||
      job.company.toLowerCase().includes(searchQuery) ||
      job.location.toLowerCase().includes(searchQuery)
  );

  let jobList = document.getElementById("jobList");
  jobList.innerHTML = "";

  filteredJobs.forEach((job) => {
    let card = document.createElement("div");
    card.className = "job-card";
    card.innerHTML = `
      <h3>${job.role}</h3>
      <p><strong>Company:</strong> ${job.company}</p>
      <p><strong>Location:</strong> ${job.location}</p>
      <p><strong>Salary:</strong> ${job.salary}</p>
      <p>${job.description || ""}</p>
    `;
    jobList.appendChild(card);
  });
}

// Call displayJobs on window load
window.onload = displayJobs;
document.getElementById("searchButton").addEventListener("click", searchJobs);

document
  .getElementById("jobSearchInput")
  .addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
      event.preventDefault(); // Prevent form submission if inside a form
      searchJobs();
    }
  });
