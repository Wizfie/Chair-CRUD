<template>
  <center class="m-5">
    @Copyright <span id="year">{{ year }}</span> Wisfie Syahbani
  </center>
</template>

<script>
export default {
  name: "CopyRight",
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>

<style></style>
