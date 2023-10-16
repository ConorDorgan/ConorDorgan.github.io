
const intro = document.querySelector('#intro .hidden');
      const projects = document.querySelector('#projects .hidden');
      const contact = document.querySelector('#contact .hidden');
      
      function isElementInViewport(el) {
  const rect = el.getBoundingClientRect();
  const threshold = 0;
  return (
    rect.top <= (window.innerHeight - threshold) &&
    rect.bottom >= threshold &&
    rect.left <= (window.innerWidth - threshold) &&
    rect.right >= threshold
  );
}
//run the isElementinViewport on document load 
document.onload = intro.classList.add('visible')

      
      function handleScroll() {
        if (isElementInViewport(intro)) {
          if (!intro.classList.contains('visible')) {
            intro.classList.add('visible');
          }
        } else {
          intro.classList.remove('visible');
        }
        
        if (isElementInViewport(projects)) {
          if (!projects.classList.contains('visible')) {
            projects.classList.add('visible');
          }
        } else {
          projects.classList.remove('visible');
        }
        
        if (isElementInViewport(contact)) {
          if (!contact.classList.contains('visible')) {
            contact.classList.add('visible');
          }
        } else {
          contact.classList.remove('visible');
        }
      }
      
      window.addEventListener('scroll', handleScroll);