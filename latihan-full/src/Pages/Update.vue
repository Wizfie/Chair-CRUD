<template>
<div>
  <Header></Header>
  <TableForm ></TableForm>
  <CopyRight></CopyRight>
</div>

</template>
<script>
import Header from "../components/Header.vue"
import TableForm from "../components/TableForm.vue"
import CopyRight from "../components/CopyRight.vue"
export default {
    name:"UpdateData",
    components:{
        Header,
        TableForm,
        CopyRight,

    }

}
</script>

<style>

</style>