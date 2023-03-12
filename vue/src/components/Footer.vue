<template>
<footer class="bg-dark text-center text-white" style="position: fixed; bottom: 0; width: 100%;">
  <div class="container p-4">
    <section class="mb-4">
      <router-link to='' class="btn btn-outline-light btn-floating m-1">
        <i class="fab fa-instagram"></i>
      </router-link>
      <router-link to='' class="btn btn-outline-light btn-floating m-1">
        <i class="fab fa-whatsapp"></i>
      </router-link>
      <router-link to='' class="btn btn-outline-light btn-floating m-1">
        <i class="fab fa-github"></i>
      </router-link>
    </section>
  </div>
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2023 Copyright:
    <router-link to='' class="text-white">Quiz.com</router-link>
  </div>
</footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>
