// Handle modal open/close
const modal = document.getElementById('editModal');
const closeModalBtn = document.getElementById('closeModal');
const editForm = document.getElementById('editForm');

document.querySelectorAll('.editBtn').forEach(btn => {
  btn.addEventListener('click', () => {
    modal.style.display = 'block';
    document.getElementById('resId').value = btn.dataset.id;
    document.getElementById('resName').value = btn.dataset.name;
    document.getElementById('resEmail').value = btn.dataset.email;
    document.getElementById('resPhone').value = btn.dataset.phone;
    document.getElementById('resDate').value = btn.dataset.date;
    document.getElementById('resTime').value = btn.dataset.time;
    document.getElementById('resGuests').value = btn.dataset.guests;
  });
});

closeModalBtn.addEventListener('click', () => {
  modal.style.display = 'none';
});

// Save edited reservation
editForm.addEventListener('submit', async e => {
  e.preventDefault();
  const updatedData = {
    id: document.getElementById('resId').value,
    name: document.getElementById('resName').value,
    email: document.getElementById('resEmail').value,
    phone: document.getElementById('resPhone').value,
    date: document.getElementById('resDate').value,
    time: document.getElementById('resTime').value,
    guests: document.getElementById('resGuests').value
  };

  await fetch('/admin/reservations/update', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(updatedData)
  });

  alert('✅ Reservation updated!');
  modal.style.display = 'none';
  location.reload();
});

// Delete reservation
document.querySelectorAll('.deleteBtn').forEach(btn => {
  btn.addEventListener('click', async () => {
    if (confirm('Are you sure you want to delete this reservation?')) {
      const id = btn.dataset.id;
      await fetch(`/admin/reservations/delete/${id}`, { method: 'DELETE' });
      alert('🗑️ Deleted successfully!');
      location.reload();
    }
  });
});
