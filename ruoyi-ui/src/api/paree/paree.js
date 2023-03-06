import request from '@/utils/request'

// 查询专利列表
export function listParee(query) {
  return request({
    url: '/paree/paree/list',
    method: 'get',
    params: query
  })
}

// 查询专利详细
export function getParee(id) {
  return request({
    url: '/paree/paree/' + id,
    method: 'get'
  })
}

// 新增专利
export function addParee(data) {
  return request({
    url: '/paree/paree',
    method: 'post',
    data: data
  })
}

// 修改专利
export function updateParee(data) {
  return request({
    url: '/paree/paree',
    method: 'put',
    data: data
  })
}

// 删除专利
export function delParee(id) {
  return request({
    url: '/paree/paree/' + id,
    method: 'delete'
  })
}
