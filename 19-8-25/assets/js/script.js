// Theme toggle (persists in localStorage)
(function () {
  const root = document.documentElement;
  const toggle = document.getElementById('themeToggle');
  const stored = localStorage.getItem('preferred-theme');

  if (stored) {
    root.setAttribute('data-bs-theme', stored);
    if (toggle) toggle.checked = stored === 'dark';
  }

  if (toggle) {
    toggle.addEventListener('change', () => {
      const next = toggle.checked ? 'dark' : 'light';
      root.setAttribute('data-bs-theme', next);
      localStorage.setItem('preferred-theme', next);
    });
  }
})();

// Footer year
document.getElementById('year').textContent = new Date().getFullYear();

// Contact form validation + toast demo (no backend)
(function () {
  const form = document.querySelector('form.needs-validation');
  const toastEl = document.getElementById('formToast');
  if (!form) return;
  form.addEventListener('submit', function (event) {
    event.preventDefault();
    event.stopPropagation();
    if (!form.checkValidity()) {
      form.classList.add('was-validated');
      return;
    }
    form.reset();
    form.classList.remove('was-validated');
    if (toastEl) new bootstrap.Toast(toastEl).show();
  });
})();


