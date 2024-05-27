document.addEventListener('DOMContentLoaded', function() {
    var dropdownWrap = document.querySelector('.i8-dropdown__wrap');
    var dropdownLabel = dropdownWrap.querySelector('.i8-dropdown__label');

    dropdownLabel.addEventListener('click', function() {
        dropdownWrap.classList.toggle('open');
    });

    // Cerrar el dropdown cuando se hace clic fuera de él
    document.addEventListener('click', function(event) {
        if (!dropdownWrap.contains(event.target)) {
            dropdownWrap.classList.remove('open');
        }
    });
});
