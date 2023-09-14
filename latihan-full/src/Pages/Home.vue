<template>
  <div>
    <Header></Header>
    <AddButton></AddButton>
    <CardData></CardData>
  </div>
</template>

<script>
import Header from "../components/Header.vue"
import AddButton from "../components/AddComp.vue"
import CardData from "../components/Card.vue"

export default {
  name: "HomePage",
  components:{
    Header,
    AddButton,
    CardData
  }

}
</script>

<style>

</style>