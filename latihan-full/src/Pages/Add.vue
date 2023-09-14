<template>
  <div>
    <HeadersComp></HeadersComp>
    <TableForm></TableForm>
    <CopyRight></CopyRight>
  </div>
</template>

<script>
import CopyRight from "../components/CopyRight.vue"
import HeadersComp from "../components/Header.vue"
import TableForm from "../components/TableForm.vue"
export default {
    name:"AddP",
    components:{
        CopyRight,
        HeadersComp,
        TableForm

    },
    methods: {
      updateStudentFunc(item){
        this.studentData = item
        this.vievForm =true;

      }
    },
    data(){
      return {
        vievForm: false,
        studentData: null
      }
    }

}
</script>

<style>

</style>