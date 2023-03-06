import request from '@/utils/request'

// 查询论文列表
export function listPap(query) {
  return request({
    url: '/pap/pap/list',
    method: 'get',
    params: query
  })
}

// 查询论文详细
export function getPap(id) {
  return request({
    url: '/pap/pap/' + id,
    method: 'get'
  })
}

// 新增论文
export function addPap(data) {
  return request({
    url: '/pap/pap',
    method: 'post',
    data: data
  })
}

// 修改论文
export function updatePap(data) {
  return request({
    url: '/pap/pap',
    method: 'put',
    data: data
  })
}

// 删除论文
export function delPap(id) {
  return request({
    url: '/pap/pap/' + id,
    method: 'delete'
  })
}
