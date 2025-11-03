// Small client-side helpers for menu buttons and reservation validation.

// Add-to-favorites placeholder
function addFavorite(id){
  // This is a placeholder. You can implement real favorites via backend later.
  alert('Added to favorites (placeholder) — item id: ' + id);
}

// Order placeholder (can be wired to cart later)
function orderPlaceholder(id){
  alert('Order functionality not implemented yet. Item id: ' + id);
}

// Client-side reservation validation before submit
function validateReservationForm(){
  const name = document.getElementById('name');
  const email = document.getElementById('email');
  const phone = document.getElementById('phone');
  const date = document.getElementById('date');
  const time = document.getElementById('time');
  const guests = document.getElementById('guests');

  if(!name.value.trim()){ alert('Please enter your name'); name.focus(); return false; }
  if(!email.value.match(/^\S+@\S+\.\S+$/)){ alert('Invalid email'); email.focus(); return false; }
  if(!phone.value.match(/^\d{7,15}$/)){ alert('Please enter a valid phone (7-15 digits)'); phone.focus(); return false; }
  if(!date.value){ alert('Please select a date'); date.focus(); return false; }
  if(!time.value){ alert('Please select time'); time.focus(); return false; }
  if(Number(guests.value) < 1){ alert('Guests must be at least 1'); guests.focus(); return false; }

  // No conflicts check on client — server will save the reservation.
  return true;
}

