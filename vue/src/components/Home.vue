<template>
 <div>
    <div>
      <Navigation />
    </div>
    <div class="video-container position-fixed">
      <video autoplay loop muted>
        <source src="@/assets/intro.mp4" type="video/mp4">
      </video>
      <div class="overlay"></div>
    </div>
    <!-- <div class="footer">
      <Footer />
    </div> -->
  </div>
</template>

<script>
import Navigation from "@/components/Navigation.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "Home",
  components: {
    Navigation,
    Footer,
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    showRankList() {
      this.$router.push("/leaderBoard");
    },
  },
};
</script>

<style scoped>
@import "bootstrap/dist/css/bootstrap.css";

.video-container {
  display: flex;
  height: 100%;
  width: 100%;
}

.video-container video {
  position: flex;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.1);
}

</style>
