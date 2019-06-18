new Vue({
  el: '#list-demo',
  data: {
    comments: [
      {groupId: 0, comment: "ここにコメント0-1が入る"},
      {groupId: 0, comment: "ここにコメント0-2が入る"},
      {groupId: 1, comment: "ここにコメント1-1が入る"},
      {groupId: 1, comment: "ここにコメント1-2が入る"},
      {groupId: 1, comment: "ここにコメント1-3が入る"},
      {groupId: 2, comment: "ここにコメント2-1が入る"},
      {groupId: 3, comment: "ここにコメント3-1が入る"},
      {groupId: 3, comment: "ここにコメント3-2が入る"},
      {groupId: 3, comment: "ここにコメント3-3が入る"},
    ],
    groupIndex: 0,
    commentIndex: 0,
    splitChar: [],
    timer: null,
  },
  methods: {
    getComment: function () {
      for (const [index, char] of this.comments[this.commentIndex].comment.split("").entries()) {
        this.splitChar.push(
          { id: index,
            char: char, }
        )
      }
      this.splitChar.push(this.comments[this.commentIndex].comment.split(""))
    },
    next: function () {
      this.groupIndex += 1
    },
    autonext: function() {
      if (this.groupIndex === this.comments[this.commentIndex+1].groupId){
        this.commentIndex = (this.commentIndex<8)?this.commentIndex+1:0
        this.splitClear()
      }else{
        clearTimeout(this.timer)
      }
    },
    splitClear: function () {
      while(this.splitChar.pop() !== undefined) {}
    },
    afterEnter: function (el) {
      this.timer = setTimeout(() => {
        this.autonext()
      }, 3000)
    },
    afterLeave: function (el) {
      // this.timer = setTimeout(() => {
      //   this.getComment()
      // }, 2000)
    }
  }
})
