import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gemingxianbei from '@/views/modules/gemingxianbei/list'
    import gemingxianbeiCollection from '@/views/modules/gemingxianbeiCollection/list'
    import gemingxianbeiLiuyan from '@/views/modules/gemingxianbeiLiuyan/list'
    import guanghuilicheng from '@/views/modules/guanghuilicheng/list'
    import guanghuilichengCollection from '@/views/modules/guanghuilichengCollection/list'
    import guanghuilichengLiuyan from '@/views/modules/guanghuilichengLiuyan/list'
    import huihuangchengjiu from '@/views/modules/huihuangchengjiu/list'
    import huihuangchengjiuCollection from '@/views/modules/huihuangchengjiuCollection/list'
    import huihuangchengjiuLiuyan from '@/views/modules/huihuangchengjiuLiuyan/list'
    import lijiehuiyi from '@/views/modules/lijiehuiyi/list'
    import lijiehuiyiCollection from '@/views/modules/lijiehuiyiCollection/list'
    import lijiehuiyiLiuyan from '@/views/modules/lijiehuiyiLiuyan/list'
    import liuyan from '@/views/modules/liuyan/list'
    import singleSeach from '@/views/modules/singleSeach/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zixun from '@/views/modules/zixun/list'
    import config from '@/views/modules/config/list'
    import dictionaryGemingxianbei from '@/views/modules/dictionaryGemingxianbei/list'
    import dictionaryGemingxianbeiCollection from '@/views/modules/dictionaryGemingxianbeiCollection/list'
    import dictionaryGuanghuilicheng from '@/views/modules/dictionaryGuanghuilicheng/list'
    import dictionaryGuanghuilichengCollection from '@/views/modules/dictionaryGuanghuilichengCollection/list'
    import dictionaryHuihuangchengjiu from '@/views/modules/dictionaryHuihuangchengjiu/list'
    import dictionaryHuihuangchengjiuCollection from '@/views/modules/dictionaryHuihuangchengjiuCollection/list'
    import dictionaryHuiyileixing from '@/views/modules/dictionaryHuiyileixing/list'
    import dictionaryLijiehuiyi from '@/views/modules/dictionaryLijiehuiyi/list'
    import dictionaryLijiehuiyiCollection from '@/views/modules/dictionaryLijiehuiyiCollection/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionarySingleSeach from '@/views/modules/dictionarySingleSeach/list'
    import dictionaryZixun from '@/views/modules/dictionaryZixun/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryGemingxianbei',
        name: '革命先辈类型',
        component: dictionaryGemingxianbei
    }
    ,{
        path: '/dictionaryGemingxianbeiCollection',
        name: '收藏表类型',
        component: dictionaryGemingxianbeiCollection
    }
    ,{
        path: '/dictionaryGuanghuilicheng',
        name: '历程时期',
        component: dictionaryGuanghuilicheng
    }
    ,{
        path: '/dictionaryGuanghuilichengCollection',
        name: '收藏表类型',
        component: dictionaryGuanghuilichengCollection
    }
    ,{
        path: '/dictionaryHuihuangchengjiu',
        name: '成就类型',
        component: dictionaryHuihuangchengjiu
    }
    ,{
        path: '/dictionaryHuihuangchengjiuCollection',
        name: '收藏表类型',
        component: dictionaryHuihuangchengjiuCollection
    }
    ,{
        path: '/dictionaryHuiyileixing',
        name: '会议类型',
        component: dictionaryHuiyileixing
    }
    ,{
        path: '/dictionaryLijiehuiyi',
        name: '几大会议',
        component: dictionaryLijiehuiyi
    }
    ,{
        path: '/dictionaryLijiehuiyiCollection',
        name: '收藏表类型',
        component: dictionaryLijiehuiyiCollection
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionarySingleSeach',
        name: '单页数据类型',
        component: dictionarySingleSeach
    }
    ,{
        path: '/dictionaryZixun',
        name: '每日资讯类型',
        component: dictionaryZixun
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gemingxianbei',
        name: '革命先辈',
        component: gemingxianbei
      }
    ,{
        path: '/gemingxianbeiCollection',
        name: '革命先辈收藏',
        component: gemingxianbeiCollection
      }
    ,{
        path: '/gemingxianbeiLiuyan',
        name: '革命先辈留言',
        component: gemingxianbeiLiuyan
      }
    ,{
        path: '/guanghuilicheng',
        name: '光辉历程',
        component: guanghuilicheng
      }
    ,{
        path: '/guanghuilichengCollection',
        name: '光辉历程收藏',
        component: guanghuilichengCollection
      }
    ,{
        path: '/guanghuilichengLiuyan',
        name: '光辉历程留言',
        component: guanghuilichengLiuyan
      }
    ,{
        path: '/huihuangchengjiu',
        name: '辉煌成就',
        component: huihuangchengjiu
      }
    ,{
        path: '/huihuangchengjiuCollection',
        name: '辉煌成就收藏',
        component: huihuangchengjiuCollection
      }
    ,{
        path: '/huihuangchengjiuLiuyan',
        name: '辉煌成就留言',
        component: huihuangchengjiuLiuyan
      }
    ,{
        path: '/lijiehuiyi',
        name: '历届会议',
        component: lijiehuiyi
      }
    ,{
        path: '/lijiehuiyiCollection',
        name: '历届会议收藏',
        component: lijiehuiyiCollection
      }
    ,{
        path: '/lijiehuiyiLiuyan',
        name: '历届会议留言',
        component: lijiehuiyiLiuyan
      }
    ,{
        path: '/liuyan',
        name: '留言板',
        component: liuyan
      }
    ,{
        path: '/singleSeach',
        name: '单页数据',
        component: singleSeach
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zixun',
        name: '每日资讯',
        component: zixun
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
